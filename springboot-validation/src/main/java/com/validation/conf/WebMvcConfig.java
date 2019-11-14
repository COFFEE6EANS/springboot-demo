package com.validation.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //将所有/static/** 访问都映射到classpath:/static/ 目录下
		registry.addResourceHandler("/index.html").addResourceLocations("classpath:/static/index.html");
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/static/");
    }
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("/");
    }
}
