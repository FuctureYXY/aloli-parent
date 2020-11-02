package com.aloli.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.aloli.interceptor.AuthenticationInterceptor;

/**
 * 定义一个配置类
 */
//后台管理系统用的用户拦截
/*@Configuration
public class InterceptorConfig implements WebMvcConfigurer {


    *//**
     addInterceptor：需要一个实现HandlerInterceptor接口的拦截器实例
     addPathPatterns：用于设置拦截器的过滤路径规则；addPathPatterns("/**")对所有请求都拦截
     excludePathPatterns：用于设置不需要拦截的过滤规则
     拦截器主要用途：进行用户登录状态的拦截，日志的拦截等。
     *//*

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加一个拦截器
        registry.addInterceptor(authenticationInterceptor())
                //配置过滤规则
                .addPathPatterns("/**")
                .excludePathPatterns("/static/**")
                .excludePathPatterns("/error")
                .excludePathPatterns("/login");
    }


    *//**
     *将这个拦截器交给spring mvc 进行管理
     *//*
    @Bean
    public AuthenticationInterceptor authenticationInterceptor() {
        return new AuthenticationInterceptor();
    }
}*/
