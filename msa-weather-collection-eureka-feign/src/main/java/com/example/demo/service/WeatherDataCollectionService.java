package com.example.demo.service;

public interface WeatherDataCollectionService {
	//根据城市ID同步天气
	void syncDataByCityId(String cityId);
}
