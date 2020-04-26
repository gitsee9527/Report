package com.waylau.spring.cloud.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DemoWeatherEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoWeatherEurekaServerApplication.class, args);
	}

}
