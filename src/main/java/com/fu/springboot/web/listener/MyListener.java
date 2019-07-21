package com.fu.springboot.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("初始化容器----------->");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
