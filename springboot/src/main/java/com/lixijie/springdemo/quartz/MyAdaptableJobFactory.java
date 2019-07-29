package com.lixijie.springdemo.quartz;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

@Component("myAdaptableJobFactory")
public class MyAdaptableJobFactory  extends AdaptableJobFactory{

	//将对象添加到spring ioc容器中并完成对象的注入
	@Autowired
	private AutowireCapableBeanFactory  autowireCapableBeanFactory;
	@Override
	protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
		// TODO Auto-generated method stub
		Object object = super.createJobInstance(bundle);
		autowireCapableBeanFactory.autowireBean(object);
		return object;
	}

	
}
