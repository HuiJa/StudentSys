package org.studentSys.config.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.studentSys.interceptor.LoginInterceptor;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

    // 这个方法是用来配置静态资源的，比如html，js，css，等等
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    }

    // 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns("/**") 表示拦截所有的请求，
        // excludePathPatterns("/login") 表示登陆不需要登陆也可以访问
        registry.addInterceptor(loginInterceptor).addPathPatterns("/student/*");
        registry.addInterceptor(loginInterceptor).addPathPatterns("/teacher/*");
        registry.addInterceptor(loginInterceptor).addPathPatterns("/parent/*");
        registry.addInterceptor(loginInterceptor).addPathPatterns("/api/*");
        registry.addInterceptor(loginInterceptor).addPathPatterns("/Introduction");
        registry.addInterceptor(loginInterceptor).addPathPatterns("/passwd");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}