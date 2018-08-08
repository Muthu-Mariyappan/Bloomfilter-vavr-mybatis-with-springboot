package com.gmm.base;

//Author: Muthu Mariyappan G

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.gmm.service", "com.gmm.base.rest", "com.gmm.entities" })
@MapperScan("com.gmm.entities")
public class BloomfilterVavrMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloomfilterVavrMybatisApplication.class, args);
	}
}
