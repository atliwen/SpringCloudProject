package com.edi.thoth.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RefreshScope
@Controller("/Config/test")
public class ConfigController
{
	@Value("${from}")
	private String from;

	@RequestMapping("/from")
	public ResponseEntity<String> from()
	{
		System.out.println("11");
		return ResponseEntity.ok(this.from);
	}
}
