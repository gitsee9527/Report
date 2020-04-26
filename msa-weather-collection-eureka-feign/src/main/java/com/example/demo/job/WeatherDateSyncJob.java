package com.example.demo.job;

import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.example.demo.service.CityClient;
import com.example.demo.service.WeatherDataCollectionService;
import com.example.demo.vo.City;
/**
 * 天气数据同步job
 * @author 77165
 *
 */
public class WeatherDateSyncJob extends QuartzJobBean{
private static final Logger logger = LoggerFactory.getLogger(WeatherDateSyncJob.class);
@Autowired
private WeatherDataCollectionService weatherDataCollectionService;

//注入feign的客户端
@Autowired
private CityClient cityClient;
@Override
protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
	// TODO Auto-generated method stub
	logger.info("Weather Data Sync job");
	//获取城市id
	List<City> cityList = null;
	 try {
		//由城市数据api微服务提供
		cityList = cityClient.listCity();
		System.out.println("cityList-->"+cityList);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	//便利城市id获取天气
	 for (City city : cityList) {
		String cityId = city.getCityId();
		weatherDataCollectionService.syncDataByCityId(cityId);
		System.out.println("同步中---》"+cityId);
	}
	 System.out.println("同步结束");
}
}
