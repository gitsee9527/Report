package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//这个类主要是配置resttemp，resttemp在启动的时候会默认的去看classpath有那些依赖
@Configuration
public class RestConfiguration {
	@Autowired
	private RestTemplateBuilder builder;
	
	@Bean
	public RestTemplate restTempplate() {
		return builder.build();
	}
}
