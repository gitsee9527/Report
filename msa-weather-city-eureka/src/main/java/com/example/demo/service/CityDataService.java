package com.example.demo.service;

import java.util.List;

import com.example.demo.vo.City;

public interface CityDataService {
	//获取城市列表
	List<City> listCity() throws Exception;
	
}
