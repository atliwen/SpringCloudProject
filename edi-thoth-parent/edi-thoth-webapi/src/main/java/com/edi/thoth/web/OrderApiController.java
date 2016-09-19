package com.edi.thoth.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edi.thoth.service.OrderApiService;

@RestController
public class OrderApiController
{

	@Autowired
	private OrderApiService apiService;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<String> saveOrder(HttpServletRequest request)
	{
		return ResponseEntity.ok(apiService.saveOrder(getParametrs(request), request));
	}

	@RequestMapping(value = "/boby", method = RequestMethod.POST)
	public ResponseEntity<String> saveOrder(@RequestBody String body, HttpServletRequest request)
	{
		return ResponseEntity.ok(apiService.saveOrder(body, request));
	}

	@RequestMapping(value = "/request", method = RequestMethod.POST)
	public ResponseEntity<String> saveOrderRequest(@RequestParam("request") String body,
			HttpServletRequest request)
	{
		return ResponseEntity.ok(apiService.saveOrder(body, request));
	}

	private String getParametrs(HttpServletRequest request)
	{
		Map<String, String[]> params = request.getParameterMap();
		String queryString = "";
		for (String key : params.keySet())
		{
			String[] values = params.get(key);
			for (int i = 0; i < values.length; i++)
			{
				String value = values[i];
				queryString += key + "=" + value + "&";
			}
		}
		// 去掉最后一个空格
		if (!StringUtils.isEmpty(queryString))
			queryString = queryString.substring(0, queryString.length() - 1);
		return queryString;
	}

}
