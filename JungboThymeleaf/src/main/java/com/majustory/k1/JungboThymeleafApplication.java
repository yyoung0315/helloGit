package com.majustory.k1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.majustory.k1","com.majustory.controller"})
public class JungboThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(JungboThymeleafApplication.class, args);
	}

}
