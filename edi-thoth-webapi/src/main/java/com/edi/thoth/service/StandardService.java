package com.edi.thoth.service;

import com.edi.thoth.domain.ClientUsers;
import com.thoth.domain.RequestData;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

/**
 * 标准模式
 *
 * @author 李文
 * @create 2017-01-09 15:54
 **/
@Service
public class StandardService
{

    private static final Logger Logger= LoggerFactory.getLogger(StandardService.class);

    @Autowired
    private DataSaveServcie dataSaveServcie;


    /**
     * 标准模式
     *
     * @return
     */
    public String standardMode(RequestData requestData, ClientUsers user) {


        String strMd5;
        String verifyData;
        try {

            verifyData = requestData.getParameterMap().get("verifyData")[0];
            //验证数据构成：4位随机数+clientFlag+客户密钥+"z宅J急S送g"+4位随机数=32位MD5.Substring(7, 21)
            String str = verifyData.substring(0, 4) + user.getClientFlag() +
                    requestData.getParameterMap().get("xml")[0] + user.getVerifyData() + "z宅J急S送g" + verifyData.substring(25, 4);
            strMd5 = DigestUtils.md5Hex(str.getBytes("UTF-8")).replace("-", "").toLowerCase().substring(7, 21);
        } catch (UnsupportedEncodingException e) {
            Logger.error(" 标准模式 生产MD5 异常  ", e);
            return standardResponse(user.getClientFlag(), "fales", "MD5 生产异常");
        }

        Logger.debug(" 接收的MD5 是 " + verifyData.substring(4, 21) + " 生产的MD5 是 " + strMd5);
        if (verifyData.substring(4, 21) == strMd5) {
            try {

                //TODO  标准模式 数据验证

                dataSaveServcie.  saveDate(requestData, user);
            } catch (Exception e) {
                return standardResponse(user.getClientFlag(), "fales", "保存数据异常");
            }
            return standardResponse(user.getClientFlag(), "true", "成功");
        }
        return standardResponse(user.getClientFlag(), "fales", "MD5 不正确");
    }


    /**
     * 标准模式 数据响应
     *
     * @param clientFlag 客户标识
     * @param success    是否成功  true  false
     * @param reason     原因
     * @return
     */
    private String standardResponse(String clientFlag, String success, String reason) {

        return "<Response>" +
                "<logisticProviderID>" + clientFlag + "</logisticProviderID>" +
                "<success>" + success + "</success>" +
                "<reason>" + reason + "</reason>" +
                "</Response> ";

    }

}
