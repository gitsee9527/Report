package com.waylau.spring.cloud.weather.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//City Client
//调用城市数据API服务的接口
@FeignClient("msa-weather-city-eureka")
public interface CityClient {
	@GetMapping("/cities")
	String listCity();
}
