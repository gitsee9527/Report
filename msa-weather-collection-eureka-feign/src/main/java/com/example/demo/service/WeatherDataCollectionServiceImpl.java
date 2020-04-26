package com.example.demo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService {
	private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";
	private static final Long TIME_OUT = 1800L;// 正常时间是半个小时，即30*60=1800s
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Override
	public void syncDataByCityId(String cityId) {
		// TODO Auto-generated method stub
		String uri = WEATHER_URI + "citykey=" + cityId;
		this.saveWeatherData(uri);
	}
	private void saveWeatherData(String uri) {
		String strBody = null;
		ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
		// json 字符串转对象   调用服务接口来获取天气数据
		ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);
		System.out.println("respString.getStatusCodeValue()-->" + respString.getStatusCodeValue());
		if (respString.getStatusCodeValue() == 200) {
			strBody = respString.getBody();
			System.out.println("strBody-->" + strBody);
		}
		// 数据写入缓存
		ops.set(uri, strBody, TIME_OUT, TimeUnit.SECONDS);
	}
}
