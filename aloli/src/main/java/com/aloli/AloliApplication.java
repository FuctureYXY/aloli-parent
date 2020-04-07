package com.aloli;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.aloli.mapper")//扫描 mapper 
@EnableCaching()//spring framework中的注解驱动的缓存管理功能
public class AloliApplication {

	public static void main(String[ ] args) {
		SpringApplication.run(AloliApplication.class, args);
	}

}
