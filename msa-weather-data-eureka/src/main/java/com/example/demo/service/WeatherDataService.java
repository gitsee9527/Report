package com.example.demo.service;

import com.example.demo.vo.WeatherReaponse;

public interface WeatherDataService {
	WeatherReaponse getDataByCityId(String cityId);
	
	WeatherReaponse getDataByCityName(String cityName);
	
}
