package com.edi.thoth.web;

import com.edi.thoth.service.OrderApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController("/")
public class OrderApiController
{


	@Autowired
	private OrderApiService apiService;
	@RequestMapping(value = "test", method = RequestMethod.GET)
	public ResponseEntity<String> saveOrderTest(@RequestParam String request)
	{
		return ResponseEntity.ok(request);
	}

	@RequestMapping(value = "{serviceName}", method = RequestMethod.POST)
	public ResponseEntity<String> saveOrder(@PathVariable String serviceName, HttpServletRequest request)
	{
		return ResponseEntity.ok(apiService.saveOrder(serviceName,"", request));
	}


	@RequestMapping(value = "{serviceName}/get", method = RequestMethod.GET)
	public ResponseEntity<String> saveGetOrder(@PathVariable String serviceName,HttpServletRequest request)
	{
		return ResponseEntity.ok(apiService.saveOrder(serviceName,"", request));
	}

	@RequestMapping(value = "{serviceName}/boby", method = RequestMethod.POST)
	public ResponseEntity<String> saveOrder(@PathVariable String serviceName,@RequestBody String body, HttpServletRequest request)
	{
		return ResponseEntity.ok(apiService.saveOrder(serviceName,body, request));
	}

	@RequestMapping(value = "{serviceName}/request", method = RequestMethod.POST)
	public ResponseEntity<String> saveOrderRequest(@PathVariable String serviceName,@RequestParam("request") String body,
			HttpServletRequest request)
	{
		return ResponseEntity.ok(apiService.saveOrder(serviceName,body, request));
	}



}
