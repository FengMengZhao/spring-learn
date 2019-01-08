package com.fmz.learn.spring.config;

import com.fmz.learn.spring.controller.HttpRequestControllerDemo;
import com.fmz.learn.spring.controller.SimpleControllerDemo;
import com.fmz.learn.spring.controller.SimpleServletController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;
import org.springframework.web.servlet.handler.SimpleServletHandlerAdapter;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.HttpRequestHandlerAdapter;
import org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.fmz.learn.spring.config", "com.fmz.learn.spring.controller"})
public class MyWebAppConfig {

    // Handler Bean
    @Bean
    public SimpleControllerDemo simpleControllerDemo(){
        return new SimpleControllerDemo();
    }

    @Bean(name="/welcomePage2")
    public HttpRequestControllerDemo httpRequestControllerDemo(){
        return new HttpRequestControllerDemo();
    }

    @Bean(name="/welcomePage3")
    public SimpleServletController simpleServletController(){
        return new SimpleServletController();
    }

    // Handler Mapping Bean
    @Bean
    public BeanNameUrlHandlerMapping beanNameUrlHandlerMapping(){
        return new BeanNameUrlHandlerMapping();
    }

    @Bean
    public SimpleUrlHandlerMapping simpleUrlHandlerMapping(){
        SimpleUrlHandlerMapping simpleUrlHandlerMapping = new SimpleUrlHandlerMapping();
        Properties property = new Properties();
        property.put("/welcomePage", "simpleControllerDemo");
        simpleUrlHandlerMapping.setMappings(property);
        return simpleUrlHandlerMapping;
    }

    // Handler Adapter Bean
    @Bean
    public SimpleControllerHandlerAdapter simpleControllerHandlerAdapter(){
        return new SimpleControllerHandlerAdapter();
    }

    @Bean
    public HttpRequestHandlerAdapter httpRequestHandlerAdapter() {
        return new HttpRequestHandlerAdapter();
    }

    @Bean
    public SimpleServletHandlerAdapter simpleServletHandlerAdapter() {
        return new SimpleServletHandlerAdapter();
    }

    // View Resolver
    @Bean
    public ViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/jsp/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }
}
