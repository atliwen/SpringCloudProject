package com.thoth.messagelistener;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.thoth.domain.ResultBean;
import com.thoth.domain.ThSnOrder;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "snserver")
public interface Edi_SuNingFeignServer
{
	@HystrixCommand(commandProperties =
	{ @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "60000") })
	@RequestMapping(method = RequestMethod.POST, value = "/sninterfaces")
	ResultBean saveTask(@RequestBody List<ThSnOrder> list);
}
