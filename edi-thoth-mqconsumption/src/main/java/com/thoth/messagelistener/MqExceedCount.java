package com.thoth.messagelistener;

import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.currencyboot.service.rocketmq.messagelistener.Interface.MqExceedCountInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
* <p>Title: MqExceedCount </p>
* <p>@Description: 超出失败次数的处理 </p>
* <p>Company:  </p>
* @author 李文
* @date   2016年9月22日 下午3:28:54 
*/
public class MqExceedCount implements MqExceedCountInterface
{

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public void exceedCount(String strBody, MessageExt msg, ConsumeConcurrentlyContext context)
	{

	}

}
