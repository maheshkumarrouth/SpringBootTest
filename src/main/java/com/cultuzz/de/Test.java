package com.cultuzz.de;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackages="com.cultuzz.de")
@SpringBootApplication
public class Test {
	
	public static void main(String args[]){
		SpringApplication.run(Test.class, args);
	}
}
