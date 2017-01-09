package com.edi.thoth.service;

import com.edi.thoth.domain.ClientUsers;
import com.edi.thoth.service.auxiliary.RequestHelp;
import com.edi.thoth.service.mongodb.ClientUsersRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoth.domain.RequestData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class OrderApiService
{

    private static final Logger Logger = LoggerFactory.getLogger(OrderApiService.class);


    @Autowired
    private ClientUsersRepository clientUsers;

    @Autowired
    private RequestHelp requestHelp;

    @Autowired
    private StandardService standardService;

    @Autowired
    private SpecialService specialService;

    private static final ObjectMapper json = new ObjectMapper();

    /**
     * 保存数据
     *
     * @param data
     * @return
     */
    public String saveOrder(String serviceName, String data, HttpServletRequest request) {

        Logger.info(" 接收到的数据是 serviceName" + serviceName + "    " + data + "    " + requestHelp.getParametrs(request));
        String outString = saveOrderDate(serviceName, data, request);
        Logger.info(" 响应的数据是 serviceName" + serviceName + "    " + outString);
        return outString;
    }


    /**
     * 处理方法
     *
     * @param data
     * @param request
     * @return
     */
    private String saveOrderDate(String serviceName, String data, HttpServletRequest request) {
        long a = System.currentTimeMillis();

        RequestData requestData = new RequestData(data, request.getParameterMap());
        try {
            ClientUsers user = clientUsers.findBycheckID(serviceName);
            if (user == null) return "未查询到该用户";
            if (!user.getIps().contains(requestHelp.getIp2(request))) return " 未查询到 Ip ";

            // 调用特殊验证处理
            if (user.getVerificationPattern() == 1) {
                return specialService.specialTreatment(user, requestData);
            }
            // 标准验证处理
            else return standardService.standardMode(requestData, user);

        } catch (Exception e) {
            Logger.error(" 未知异常 ", e);
            //return callApi.bodyApi("failure", requestData);
            return "未知异常";
        } finally {
            System.out.println("\r<br>执行耗时 : " + (System.currentTimeMillis() - a));
        }

    }


}
