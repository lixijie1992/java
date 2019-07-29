package com.lixijie.springdemo.quartz;

import org.quartz.ScheduleBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * quartz 配置
 * @author lixijie
 *
 */
@Configuration
public class QuartzConfig {

	/**
	 * 获取Job 任务
	 * @return  JobDetailFactoryBean
	 */
	@Bean
	public JobDetailFactoryBean jobDetailFactoryBean() {
		JobDetailFactoryBean factory = new JobDetailFactoryBean();
		factory.setJobClass(FirstJob.class);
		return factory;
	}
	
	/**
	 * 
	 * @param jobDetailFactoryBean
	 * @return CronTriggerFactoryBean
	 */
	@Bean
	public CronTriggerFactoryBean  cronTriggerFactoryBean(JobDetailFactoryBean  jobDetailFactoryBean) {
		CronTriggerFactoryBean factory = new CronTriggerFactoryBean();
		factory.setCronExpression("0/5 * * * * ?");
	
		factory.setJobDetail(jobDetailFactoryBean.getObject());
		return factory;
	}
	/**
	 * 
	 * @param cronTriggerFactoryBean
	 * @return SchedulerFactoryBean
	 */
	@Bean
	public SchedulerFactoryBean  schedulerFactoryBean(CronTriggerFactoryBean  cronTriggerFactoryBean,MyAdaptableJobFactory myAdaptableJobFactory) {
		SchedulerFactoryBean factory = new SchedulerFactoryBean();
		factory.setJobFactory(myAdaptableJobFactory);
		factory.setTriggers(cronTriggerFactoryBean.getObject());
		return factory;
	}
}
