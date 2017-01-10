package com.edi.thoth.service.auxiliary;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.thoth.domain.RequestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
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



	/**
	 * 成功 数据响应
	 */
	public String success(RequestData body){
		return bodyApi("success",body);
	}


	/**
	 * 失败 数据响应
	 * @param state   状态  0 是数据验证 失败  1 是基础数据验证失败
	 * @param body
	 * @return
	 */
	public	String failure(Integer state, RequestData body){
		return bodyApi("failure/"+state,body);
	}

	/**
	 * 验证数据
	 *        对客户数据的校验
	 *
	 * @param body
	 * @return ok 是成功  否则 都是失败
	 */
	public	String check(RequestData body){
		return bodyApi("Check",body);
	}

	/**
	 *  基础数据 验证
	 *      对用户数据做基础数据验证  确保接收到的数据满足最低标准处理
	 *
	 * @param body
	 * @return
	 */
	public	String dataVerification(@RequestBody RequestData body){
		return bodyApi("data/verification",body);
	}

}
