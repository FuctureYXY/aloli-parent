package com.aloli;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
//exclude = {DataSourceAutoConfiguration.class} 是为了使用  yml  配置 不设置设个  则DataSource报错
@SpringBootApplication
@MapperScan("com.aloli.mapper")//扫描 mapper
@EnableCaching()//spring framework中的注解驱动的缓存管理功能
public class AloliApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext run = SpringApplication.run(AloliApplication.class, args);

		String property = run.getEnvironment().getProperty("user.age");
		System.out.println(property);
	}

}
