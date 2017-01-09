package com.edi.thoth.service.auxiliary;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 请求辅助类
 *
 * @author 李文
 * @create 2017-01-09 15:51
 **/
@Service
public class RequestHelp
{
    /**
     * 获取 真实IP 地址
     *
     * @param request
     * @return
     */
    public String getIp2(HttpServletRequest request) {
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

    /**
     * 获取 全部参数值
     *
     * @param request
     * @return
     */
    public String getParametrs(HttpServletRequest request) {
        Map<String, String[]> params = request.getParameterMap();
        String queryString = "";
        for (String key : params.keySet()) {
            String[] values = params.get(key);
            for (int i = 0; i < values.length; i++) {
                String value = values[i];
                queryString += key + "=" + value + "&";
            }
        }
        // 去掉最后一个空格
        if (!org.springframework.util.StringUtils.isEmpty(queryString))
            queryString = queryString.substring(0, queryString.length() - 1);
        return queryString;
    }

}
