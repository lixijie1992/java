package com.lixijie.springdemo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class secondListener  implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("进入Listener002");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
