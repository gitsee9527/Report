package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.WeatherDataService;
import com.example.demo.vo.WeatherReaponse;

@RestController
@RequestMapping("/weather")
public class WeatherController {
	@Autowired
	private WeatherDataService weatherDataService;
	@GetMapping("/cityId/{cityId}")
	public WeatherReaponse getWeatherByCityId(@PathVariable("cityId")String cityId) {
		
		return weatherDataService.getDataByCityId(cityId);
	}
	@GetMapping("/cityName/{cityName}")
	public WeatherReaponse getWeatherByCityName(@PathVariable("cityName")String cityName) {
		
		return weatherDataService.getDataByCityName(cityName);
	}
}
