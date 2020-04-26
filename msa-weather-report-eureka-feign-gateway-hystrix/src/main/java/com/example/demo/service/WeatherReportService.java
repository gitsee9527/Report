package com.example.demo.service;

import com.example.demo.vo.Weather;

public interface WeatherReportService {
	Weather getDatabyCityId(String cityId);
}
