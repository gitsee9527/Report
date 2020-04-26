package com.example.demo.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.vo.City;

@FeignClient("msa-weather-city-eureka")
public interface CityClient {
	@GetMapping("/cities")
	List<City> listCity() throws Exception;
}
