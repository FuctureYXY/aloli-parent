package com.aloli;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.aloli.mapper")//扫描 mapper 
public class AloliApplication {

	public static void main(String[] args) {
		SpringApplication.run(AloliApplication.class, args);
	}

}
