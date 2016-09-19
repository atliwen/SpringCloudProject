package com.thoth.web;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController implements ThothClientInterface
{

	@Override
	public String success(String body)
	{
		// 成功 数据响应
		return "成功";
	}

	@Override
	public String failure(String body)
	{
		// 失败 数据响应
		return "失败";
	}

	@Override
	public String check(String body)
	{
		// 验证数据 ok 是成功 否则 都是失败
		return "ok";
	}

	@Override
	public String checkfailure(String body)
	{
		// 验证失败数据响应
		return "验证失败";
	}

}