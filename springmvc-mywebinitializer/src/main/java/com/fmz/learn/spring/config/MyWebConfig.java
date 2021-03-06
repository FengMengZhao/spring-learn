package com.fmz.learn.spring.config;

import com.fmz.learn.spring.controller.MyMvcController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class MyWebConfig {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        //commenting next line, setViewClass, as by
        // default the resolver's view is the same
        //viewResolver.setViewClass(JstlView.class);

        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public MyMvcController myMvcController() {
        return new MyMvcController();
    }
}
