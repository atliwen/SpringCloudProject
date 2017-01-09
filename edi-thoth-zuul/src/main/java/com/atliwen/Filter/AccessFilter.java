package com.atliwen.Filter;

import com.netflix.zuul.ZuulFilter;

/**
 * 路由过滤器
 *
 * @author 李文
 * @create 2017-01-09 13:14
 **/
public class AccessFilter extends ZuulFilter
{
    @Override
    public String filterType() {
        return null;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() {
        return null;
    }
}
