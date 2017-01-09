package com.thoth.web;

import com.thoth.Interface.webapi.OrderApiInterface;
import com.thoth.domain.RequestData;
import org.springframework.web.bind.annotation.RestController;

/**
* <p>Title: OrderController </p>
* <p>@Description: webapi 项目   客户B  OrderApi 接口方法实现类 </p>
* <p>Company:  </p>
* @author 李文
* @date   2016年9月19日 下午3:39:38 
*/
@RestController
public class OrderController implements OrderApiInterface
{

	@Override
	public String success(RequestData body)
	{
		// 成功 数据响应
		return "成功";
	}

	@Override
	public String failure(RequestData body)
	{
		// 失败 数据响应
		return "失败";
	}

	@Override
	public String check(RequestData body)
	{
		// 验证数据 ok 是成功 否则 都是失败
		return "ok";
	}

	@Override
	public String checkfailure(RequestData body)
	{
		// 验证失败数据响应
		return "验证失败";
	}

	@Override
	public String dataConversion(RequestData body) {
		return null;
	}

}