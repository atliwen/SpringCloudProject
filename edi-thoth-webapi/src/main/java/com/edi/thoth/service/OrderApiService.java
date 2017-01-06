package com.edi.thoth.service;

import com.edi.thoth.domain.ClientUsers;
import com.edi.thoth.service.mongodb.ClientUsersRepository;
import com.edi.thoth.service.mongodb.ThothOrderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoth.domain.ThothOrder;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class OrderApiService
{

    private static final Logger Logger = LoggerFactory.getLogger(OrderApiService.class);

    @Value("${Topic}")
    private String Topic;

    @Value("${Tags}")
    private String Tags;

    @Autowired
    private CallApi callApi;

    @Autowired
    private ThothOrderRepository tOrder;

    @Autowired
    private ClientUsersRepository clientUsers;

    @Autowired
    private MqProducer mq;


    private static final ObjectMapper json = new ObjectMapper();

    /**
     * 保存数据
     * @param data
     * @return
     */
    public String saveOrder(String data, HttpServletRequest request) {

        Logger.info(" 接收到的数据是 " + data);
        String outString = saveOrderDate(data, request);
        Logger.info(" 响应的数据是 " + outString);
        return outString;
    }


    /**
     * 处理方法
     * @param data
     * @param request
     * @return
     */
    private String saveOrderDate(String data, HttpServletRequest request) {
        long a = System.currentTimeMillis();
        try {
            ClientUsers users = clientUsers.findByips(getIp2(request));
            if (users == null) {
                return "Ip 未查询到";
            }
            callApi.setServerID(users.getCheckID());

            long a1 = System.currentTimeMillis();
            String Check = callApi.bodyApi("Check", data);
            System.out.println("\r<br>执行耗时 a1 : " + (System.currentTimeMillis() - a1));

            if (!"ok".equals(Check))// 调用 验 证 API
                return callApi.bodyApi("Check/failure", data);// 调用验证失败 API

            try {
                // 保存数据
                // 这里只做数据 记录
                // TODO 如后期 有日志管理  这里可以取消
                ThothOrder thothOrder = new ThothOrder();
                thothOrder.setClientFlag(users.getClientFlag());
                thothOrder.setDataOrder(data);
                thothOrder.setIsSend(0);
                thothOrder.setCheckID(users.getCheckID());
                thothOrder.setRemark("接收数据成功");
                tOrder.save(thothOrder);
                // 添加MQ
                mq.send(Topic, Tags, json.writeValueAsString(thothOrder));

            } catch (Exception e) {
                Logger.error(" 保存数据 失败 ", e);
                return callApi.bodyApi("failure", data);// 调用 失败 API
            }
            long a2 = System.currentTimeMillis();
            String outString = callApi.bodyApi("success", data);// 调用 成功API
            System.out.println("\r<br>执行耗时 a2 : " + (System.currentTimeMillis() - a2));

            return outString;
        } catch (Exception e) {
            Logger.error(" 未知异常 ", e);
            return callApi.bodyApi("failure", data);
        } finally {
            System.out.println("\r<br>执行耗时 : " + (System.currentTimeMillis() - a));
        }

        // 40 ms 多次请求后 平均
        /*
         * 经过测试 在一次调用 bodyApi 方法的时候 耗时较长 584ms 第二次 8 ms bodyApi 后续请求 都在6ms 左右
		 */
    }


    /**
     * 获取 真实IP 地址
     *
     * @param request
     * @return
     */
    private String getIp2(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if (index != -1) return ip.substring(0, index);
            else return ip;
        }
        ip = request.getHeader("X-Real-IP");
        if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            return ip;
        }
        return request.getRemoteAddr();
    }
}
