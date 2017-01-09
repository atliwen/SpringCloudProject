package com.edi.thoth.domain;

import java.util.List;

/**
 * <p>Title: ClientUsers </p>
 * <p>@Description: TODO </p>
 * <p>Company:  </p>
 *
 * @author 李文
 * @date 2016年9月18日 下午5:18:37
 */
public class ClientUsers
{
    /**
     * 用户名称
     */
    private String userName;

    /**
     * ip
     */
    private List<String> ips;

    /**
     * 客户标识
     */
    private String clientFlag;

    /**
     * 客户服务ID
     */
    private String checkID;



    /**
     *  用户秘钥
     */
    private String verifyData;

    /**
     * 验证模式  0 标准模式  1 特殊微服务模式
     */
    private Integer verificationPattern;


    /**
     * 数据转换模式  0 标准模式 1 自定义转换模式 2 特殊微服务模式
     */
    private Integer dataPattern;

    /**
     * 获取用户名称
     *
     * @return userName 用户名称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名称
     *
     * @param userName 用户名称
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取ip
     *
     * @return ips ip
     */
    public List<String> getIps() {
        return ips;
    }

    /**
     * 设置ip
     *
     * @param ips ip
     */
    public void setIps(List<String> ips) {
        this.ips = ips;
    }

    /**
     * 获取客户标识
     *
     * @return clientFlag 客户标识
     */
    public String getClientFlag() {
        return clientFlag;
    }

    /**
     * 设置客户标识
     *
     * @param clientFlag 客户标识
     */
    public void setClientFlag(String clientFlag) {
        this.clientFlag = clientFlag;
    }

    /**
     * 获取客户服务ID
     *
     * @return checkID 客户服务ID
     */
    public String getCheckID() {
        return checkID;
    }

    /**
     * 设置客户服务ID
     *
     * @param checkID 客户服务ID
     */
    public void setCheckID(String checkID) {
        this.checkID = checkID;
    }


    /**
     * 获取 验证模式  0 标准模式  1 特殊微服务模式
     */
    public Integer getVerificationPattern() {
        return this.verificationPattern;
    }

    /**
     * 设置 验证模式  0 标准模式  1 特殊微服务模式
     */
    public void setVerificationPattern(Integer verificationPattern) {
        this.verificationPattern = verificationPattern;
    }

    /**
     * 获取 数据转换模式  0 标准模式 1 自定义转换模式 2 特殊微服务模式
     */
    public Integer getDataPattern() {
        return this.dataPattern;
    }

    /**
     * 设置 数据转换模式  0 标准模式 1 自定义转换模式 2 特殊微服务模式
     */
    public void setDataPattern(Integer dataPattern) {
        this.dataPattern = dataPattern;
    }


    /**
     * 获取  用户秘钥
     */
    public String getVerifyData() {
        return this.verifyData;
    }

    /**
     * 设置  用户秘钥
     */
    public void setVerifyData(String verifyData) {
        this.verifyData = verifyData;
    }
}
