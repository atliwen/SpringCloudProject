package com.thoth.domain;

import java.util.Map;

/**
 * Created by admin on 2017-01-09.
 */
public class RequestData
{

    /**
     *  数据
     */
    private String data;

    /**
     *  请求 数据
     */
    private Map<String,String []> parameterMap;


    /**
     * 获取  数据
     */
    public String getData() {
        return this.data;
    }

    /**
     * 设置  数据
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * 获取  请求 数据
     */
    public Map<String, String[]> getParameterMap() {
        return this.parameterMap;
    }

    /**
     * 设置  请求 数据
     */
    public void setParameterMap(Map<String, String[]> parameterMap) {
        this.parameterMap = parameterMap;
    }

    public RequestData() {
    }

    public RequestData(String data, Map<String, String[]> parameterMap) {
        this.data = data;
        this.parameterMap = parameterMap;
    }
}
