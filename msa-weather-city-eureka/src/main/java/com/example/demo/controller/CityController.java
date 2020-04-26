package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.CityDataService;
import com.example.demo.vo.City;

@RestController
@RequestMapping("/cities")
public class CityController {
	@Autowired
	private CityDataService cityDataService;
	@GetMapping
	public List<City> listCity() throws Exception{
		return cityDataService.listCity();
	}
}
