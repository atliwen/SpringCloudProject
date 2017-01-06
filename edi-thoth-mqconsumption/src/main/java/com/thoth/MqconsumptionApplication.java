package com.thoth;

import com.currencyboot.service.rocketmq.MqProducer;
import com.currencyboot.service.rocketmq.messagelistener.Interface.MessageListenerConsumerInterface;
import com.currencyboot.service.rocketmq.messagelistener.Interface.MqExceedCountInterface;
import com.thoth.messagelistener.ConsumableMessageListenerConsumer;
import com.thoth.messagelistener.MqExceedCount;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MqconsumptionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MqconsumptionApplication.class, args);
	}

	@Bean
	@LoadBalanced
	RestTemplate restTemplate()
	{
		return new RestTemplate();
	}

	/**
	 *  生产者
	 * @return
	 */
	@Bean
	MqProducer mqProducer()
	{
		return new MqProducer();
	}


	/**
	 * 内销
	 * @return
	 */
	@Bean
	MessageListenerConsumerInterface consumableMessageListenerConsumer()
	{
		return new ConsumableMessageListenerConsumer();
	}

	/**
	 * 容错异常处理
	 * @return
	 */
	@Bean
	MqExceedCountInterface mqExceedCount()
	{
		return new MqExceedCount();
	}
}
