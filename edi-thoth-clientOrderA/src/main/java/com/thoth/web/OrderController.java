package com.thoth.web;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thoth.Interface.webapi.OrderApiInterface;

/**
* <p>Title: OrderController </p>
* <p>@Description: webapi 项目   客户A  OrderApi 接口方法实现类 </p>
* <p>Company:  </p>
* @author 李文
* @date   2016年9月19日 下午3:40:23 
*/
@RestController
public class OrderController implements OrderApiInterface
{
	/**
	 * 成功 数据响应
	 * @param body
	 * @return
	 */
	@Override
	public String success(String body)
	{
		// 成功 数据响应
		return "成功";
	}
	/**
	 * 失败 数据响应
	 * @param body
	 * @return
	 */
	@Override
	public String failure(String body)
	{
		// 失败 数据响应
		return "失败";
	}
	/**
	 * 验证数据
	 * @param body
	 * @return   ok 是成功  否则 都是失败
	 */
	@Override
	public String check(String body)
	{
		// 验证数据 ok 是成功 否则 都是失败
		return "ok";
	}
	/**
	 * 验证失败数据响应
	 * @param body
	 * @return
	 */
	@Override
	public String checkfailure(String body)
	{
		// 验证失败数据响应
		return "验证失败";
	}
	/**
	 *   数据转换方法
	 * @param body
	 * @return
	 */
	@Override
	public String dataConversion(@RequestBody String body) {
		return null;
	}

}