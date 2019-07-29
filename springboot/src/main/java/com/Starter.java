package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * 1/启动类
 * 2/Servlet全局扫描    启动时扫描@WebServlet注解类
 */
@SpringBootApplication
@ServletComponentScan
@MapperScan("com.lixijie.springdemo.mapper")
@EnableCaching  //启动缓存
@EnableScheduling    //启动定时任务
public class Starter {
	
	@Bean
	public HttpMessageConverters  fastJsonHttpMessageConverters() {
		
		//创建FastJsonHttpMessageConverter  消息转换对象
		FastJsonHttpMessageConverter fastJsonHttpMessageConverter =new FastJsonHttpMessageConverter();
		//配置FastJsonConfig
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		//在FastJsonHttpMessageConverter中添加配置
		fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
		
		HttpMessageConverter<?> converters = fastJsonHttpMessageConverter;
		return new HttpMessageConverters(converters);
		
	}
	
    public static void main(String[] args) {
        SpringApplication.run(Starter.class,args);
    }

}
