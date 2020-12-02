package com.example.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableConfigurationProperties
@ComponentScan(basePackages = { "com.example.java" })
@EnableDiscoveryClient
public class Assignment4JpaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Assignment4JpaServiceApplication.class, args);
		System.setProperty("spring.config.name", "assignment4-service");
		System.out.println("Assignment-4 Micro-service is ready....");
	}

}
