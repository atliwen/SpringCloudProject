package com.edi.thoth.service;

import org.springframework.beans.factory.annotation.Autowired;
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
	public String bodyApi(String function, String body)
	{
		String url = "http://" + serverID + "/" + function;

		return restTemplate.postForEntity(url, body, String.class).getBody();
	}

}
