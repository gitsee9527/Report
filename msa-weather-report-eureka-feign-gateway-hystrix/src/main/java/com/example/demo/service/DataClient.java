package com.example.demo.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.vo.City;
import com.example.demo.vo.WeatherReaponse;

@FeignClient(name="msa-weather-eureka-client-zuul",fallback=DataClientFallback.class)
public interface DataClient {
	
	//获取城市列表
	@GetMapping("city/cities")
	List<City> listCity() throws Exception;
	//根据城市ID查询天气数据
	@GetMapping("data/weather/cityId/{cityId}")
	WeatherReaponse getDataByCityId(@PathVariable("cityId")String cityId);
}
