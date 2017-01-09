package com.edi.thoth.service.auxiliary;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.thoth.domain.RequestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * <p>Title: CallApi </p>
 * <p>@Description: 通用调用  Api  </p>
 * <p>Company:  </p>
 * @author 李文
 * @date   2016年9月18日 下午2:03:13 
 */

@Service
@Scope("prototype")
public class CallApi
{

	@Autowired
	RestTemplate restTemplate;

	private String serverID;

	public void setServerID(String serverID)
	{
		this.serverID = serverID;
	}

	/**
	 *  字符串 数据 转发
	 * @param function   功能
	 * @param body		   数据
	 * @return
	 */
	@HystrixCommand(fallbackMethod = "bodyApiback")
	public String bodyApi(String function, RequestData body)
	{
		String url = "http://" + serverID + "/" + function;
		return restTemplate.postForEntity(url, body, String.class).getBody();
	}

	/**
	 * 断路器
	 * @param function
	 * @param body
	 * @return
	 */
	public String bodyApiback(String function, RequestData body)
	{
		return "超时";
	}
}
