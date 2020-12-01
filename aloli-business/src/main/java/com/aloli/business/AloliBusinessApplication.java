package com.aloli.business;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//exclude = {DataSourceAutoConfiguration.class} 是为了使用  yml  配置 不设置设个  则DataSource报错
@EnableAspectJAutoProxy(exposeProxy = true)  //暴露当前代理对象到当前线程进行绑定
@SpringBootApplication(scanBasePackages = "com.aloli")
@EnableDiscoveryClient
@MapperScan("com.aloli.business.mapper")//扫描 mapper
@EnableCaching()//spring framework中的注解驱动的缓存管理功能
@EnableFeignClients(basePackages = {"com.aloli.security.api"})  //  feign 扫描路径
public class AloliBusinessApplication {

    public static void main(String[] args) {
        SpringApplication.run(AloliBusinessApplication.class, args);
    }

}
