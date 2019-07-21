package com.fu.springboot.web.config;

import com.fu.springboot.web.common.MyLocalResolver;
import com.fu.springboot.web.filter.MyFilter;
import com.fu.springboot.web.intercept.LoginInterceptor;
import com.fu.springboot.web.listener.MyListener;
import com.fu.springboot.web.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.Arrays;

@Configuration
public class MyWebConfiguration implements WebMvcConfigurer {

    /*注册view-controller*/
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        super.addViewControllers(registry);
        registry.addViewController("/").setViewName("webtest/login");
        registry.addViewController("/webtest/login.html").setViewName("webtest/login");
        registry.addViewController("/webtest/manage.html").setViewName("webtest/manage");
    }

    /*注册国际化*/
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocalResolver();
    }

    /*注册拦截器*/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").
                excludePathPatterns("/webtest/login.html", "/",
                        "/user/login", "/user/loginsuccess", "/static/**");
    }

    /*注册servlet*/
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean servletRegistrationBean =
                new ServletRegistrationBean(new MyServlet(),"/myservlet");
        return servletRegistrationBean;
    }
    /*注册filter*/
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean =
                new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/myservlet","/hello"));
        return filterRegistrationBean;
    }
    /*注册listener*/
    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean(){
        ServletListenerRegistrationBean servletListenerRegistrationBean =
                new ServletListenerRegistrationBean(new MyListener());
        return servletListenerRegistrationBean;
    }
}
