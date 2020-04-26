package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.vo.City;
import com.example.demo.vo.WeatherReaponse;

/**
 * DataClient 的一个fallback类
 * @author 77165
 *
 */
@Service
public class DataClientFallback implements DataClient {

	@Override
	public List<City> listCity() throws Exception {
		List<City> cityList = null;
		cityList = new ArrayList<>();
		City city = new City();
		city.setCityId("101181001");
		city.setCityName("商丘");
		cityList.add(city);
		
		City city2 = new City();
		city2.setCityId("101181801");
		city2.setCityName("济源");
		cityList.add(city2);
		return cityList;
	}

	@Override
	public WeatherReaponse getDataByCityId(String cityId) {
		return null;
	}

}
