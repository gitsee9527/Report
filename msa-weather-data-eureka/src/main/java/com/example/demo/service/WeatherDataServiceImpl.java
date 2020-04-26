package com.example.demo.service;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.vo.WeatherReaponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class WeatherDataServiceImpl implements WeatherDataService {
	private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Override
	public WeatherReaponse getDataByCityId(String cityId) {
		String uri = WEATHER_URI + "citykey=" + cityId;
		return this.doGetWeather(uri);
	}

	@Override
	public WeatherReaponse getDataByCityName(String cityName) {
		String uri = WEATHER_URI + "city=" + cityName;
		return this.doGetWeather(uri);
	}

	private WeatherReaponse doGetWeather(String uri) {
		String key = uri;
		WeatherReaponse resp = null;
		String body = null;
		ObjectMapper objectMapper = new ObjectMapper();
		Boolean hasKey = stringRedisTemplate.hasKey(uri);
		ValueOperations<String, String> ops =stringRedisTemplate.opsForValue();
		if (hasKey) {
			body = ops.get(key);
		}else {
			//缓存没有，抛出异常
			throw new RuntimeException("has no data");
		}
		try {
			resp = objectMapper.readValue(body, WeatherReaponse.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resp;
	}
}
