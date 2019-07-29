package com;

import com.lixijie.springdemo.filter.SecondFilter;
import com.lixijie.springdemo.listener.secondListener;
import com.lixijie.springdemo.servlet.SecondServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.lixijie.springdemo.mapper")
@EnableCaching  //启动缓存
public class Start2 {

    public static void main(String[] args) {
        SpringApplication.run(Start2.class,args);
    }

    /**
     * 注册Servlet
     * @return
     */
    @Bean
    public ServletRegistrationBean getServlet(){
        ServletRegistrationBean  sr = new ServletRegistrationBean(new SecondServlet());
        sr.addUrlMappings("/second");
        return  sr;
    }

    /**
     * 注册Filter
     * @return
     */
    @Bean
    public FilterRegistrationBean getFilter(){
        FilterRegistrationBean  sf = new FilterRegistrationBean(new SecondFilter());
      /* sf.addUrlPatterns(new String[]{"*.do","*.jsp"});*/
        sf.addUrlPatterns(new String("/getMap"));
        return  sf;
    }

    /**
     * 注册Listener
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean<secondListener> getListener(){
        ServletListenerRegistrationBean<secondListener>  sl = new ServletListenerRegistrationBean<secondListener>(new secondListener());

        return  sl;
    }

}