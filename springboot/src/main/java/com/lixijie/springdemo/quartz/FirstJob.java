package com.lixijie.springdemo.quartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;

import com.lixijie.springdemo.service.UserServices;


public class FirstJob implements Job {

	@Autowired
	private UserServices userService;
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		System.out.println("执行工作" + new Date());
		userService.findUser();
	}

}
