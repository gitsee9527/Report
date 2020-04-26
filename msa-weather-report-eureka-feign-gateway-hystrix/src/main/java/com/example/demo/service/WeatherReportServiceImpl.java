package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.vo.Weather;
import com.example.demo.vo.WeatherReaponse;
@Service
public class WeatherReportServiceImpl implements WeatherReportService {
	@Autowired
	private DataClient dataClient;
	@Override
	public Weather getDatabyCityId(String cityId) {
		//改天天气数据 api微服务提供
		WeatherReaponse data =dataClient.getDataByCityId(cityId);
		if(data!=null) {
			Weather data3 = data.getData();
			return data3;
		}else {
			return null;
		}
	}

}
