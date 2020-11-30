package com.aloli.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
//exclude = {DataSourceAutoConfiguration.class} 是为了使用  yml  配置 不设置设个  则DataSource报错
@EnableAspectJAutoProxy(exposeProxy = true)  //暴露当前代理对象到当前线程进行绑定
@SpringBootApplication(scanBasePackages = "com.aloli")
@EnableDiscoveryClient
@MapperScan("com.aloli.security.mapper")//扫描 mapper
@EnableCaching()//spring framework中的注解驱动的缓存管理功能
public class AloliApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext run = SpringApplication.run(AloliApplication.class, args);
		String property = run.getEnvironment().getProperty("user.age");
		System.out.println(property);
	}

}
