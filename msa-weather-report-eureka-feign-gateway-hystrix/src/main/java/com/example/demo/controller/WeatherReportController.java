package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.DataClient;
import com.example.demo.service.WeatherReportService;
import com.example.demo.vo.City;

@RestController
@RequestMapping("/report")
public class WeatherReportController {
	@Autowired
	private WeatherReportService weatherReportService;
	@Autowired
	private DataClient dataClient;
	@GetMapping("/cityId/{cityId}")
	public ModelAndView  getReportByCityId(@PathVariable("cityId")String cityId,Model model) throws Exception {
		//获取城市id
		//TODO 改为由城市数据api微服务提供
		List<City> cityList = null;
		 try {
			//TODO 改为由城市数据api微服务提供
			cityList = dataClient.listCity();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("title","韩帅帅的天气预报");
		model.addAttribute("cityId",cityId);
		model.addAttribute("cityList",cityList);
		model.addAttribute("report",weatherReportService.getDatabyCityId(cityId));
		return new ModelAndView("weather/report","reportModel",model);
	}
}
