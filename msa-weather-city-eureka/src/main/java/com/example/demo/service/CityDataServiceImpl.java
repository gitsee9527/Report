package com.example.demo.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.example.demo.util.XmlBuilder;
import com.example.demo.vo.City;
import com.example.demo.vo.cityList;
@Service
public class CityDataServiceImpl implements CityDataService{

	@Override
	public List<City> listCity() throws Exception {
		//读取xml
		ClassPathResource resource = new ClassPathResource("citylist.xml");
		BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(),"utf-8"));
		StringBuffer sb = new StringBuffer();
		String line = "";
		while((line = br.readLine())!=null) {
			sb.append(line);
		}
		br.close();
		//xml转为java对象
		try {
			cityList citylist = (cityList)XmlBuilder.xmlStrToObject(cityList.class, sb.toString());
	            System.out.println("citylist--"+citylist.getCityList());
			return citylist.getCityList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

}
