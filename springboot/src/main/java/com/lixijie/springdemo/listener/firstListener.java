package com.lixijie.springdemo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * <llistener>
 *     <listener-class>com.lixijie.springdemo.listener.firstListener</listener-class>
 * </llistener>
 * @author lixijie
 */
@WebListener
public class firstListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("进入Listener001");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
