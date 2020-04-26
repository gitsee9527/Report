package com.example.demo.config;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.job.WeatherDateSyncJob;

@Configuration
public class QuartzConfiguration {
	private static final int TIME = 120;  //更新频率 半个小时
	//JobDetail  定义一个特定的job
	@Bean
	public JobDetail WeatherDateSyncJobDetail() {
		return JobBuilder.newJob(WeatherDateSyncJob.class).withIdentity("WeatherDateSyncJob")//创建一个job并定义一个名称
				.storeDurably().build();
		
		
	}
	//Trigger    触发的详情
	@Bean
	public Trigger WeatherDateSyncTrigger() {
		SimpleScheduleBuilder schedBuilder = SimpleScheduleBuilder.simpleSchedule()
				.withIntervalInSeconds(TIME).repeatForever();//几秒钟任务重复执行
		return TriggerBuilder.newTrigger().forJob( WeatherDateSyncJobDetail()).withIdentity("WeatherDateSyncTrigger")
				.withSchedule(schedBuilder).build();
	}
}
