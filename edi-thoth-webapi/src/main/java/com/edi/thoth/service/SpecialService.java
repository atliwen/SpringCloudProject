package com.edi.thoth.service;

import com.edi.thoth.domain.ClientUsers;
import com.edi.thoth.service.auxiliary.CallApi;
import com.thoth.domain.RequestData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 特殊处理
 *
 * @author 李文
 * @create 2017-01-09 16:06
 **/
@Service
public class SpecialService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(SpecialService.class);

    @Autowired
    private CallApi callApi;
    @Autowired
    private DataSaveServcie dataSaveServcie;

    /**
     * 特殊处理
     *
     * @param user
     * @return
     * @throws Exception
     */
    public String specialTreatment(ClientUsers user, RequestData requestData) throws Exception {

        // 设置服务调用 服务名称
        callApi.setServerID(user.getCheckID());

        long a1 = System.currentTimeMillis();
        String Check = callApi.check(requestData);
        LOGGER.debug("<br>执行耗时 a1 : " + (System.currentTimeMillis() - a1));

        if (!"ok".equals(Check))// 调用 验 证 API
            return callApi.failure(0, requestData);// 调用验证失败 API

        a1 = System.currentTimeMillis();
        String dataVerification = callApi.dataVerification(requestData);
        LOGGER.debug("<br>执行耗时 a1 : " + (System.currentTimeMillis() - a1));

        if (!"ok".equals(dataVerification))// 调用 验 证 API
            return callApi.failure(1, requestData);// 调用验证失败 API

        // 保存数据
        dataSaveServcie.saveDate(requestData, user);

        long a2 = System.currentTimeMillis();
        String outString = callApi.bodyApi("success", requestData);// 调用 成功API
        LOGGER.debug("<br>执行耗时 a2 : " + (System.currentTimeMillis() - a2));

        return outString;
    }


}