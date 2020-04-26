package com.waylau.spring.cloud.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.waylau.spring.cloud.weather.service.CityClient;

@RestController
public class Citycontroller {
	@Autowired
	private CityClient cityClient;
	@GetMapping("/cities")
	@HystrixCommand(fallbackMethod = "defaultCities")
	public String listCity(){
		//通过Feign客户端查找
		String listCity = cityClient.listCity();
		return listCity;
	}
	public String defaultCities() {
		return "City Data Server is down!";
	}
}
