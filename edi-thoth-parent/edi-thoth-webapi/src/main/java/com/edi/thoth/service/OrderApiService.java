package com.edi.thoth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderApiService
{

	@Autowired
	private ThothOrderRepository thRepository;

	@Autowired
	private MqProducer mqProducer;

	/**
	 * 保存数据
	 * @param data
	 * @return
	 */
	public String saveOrder(String data)
	{
		return data;
	}

}
