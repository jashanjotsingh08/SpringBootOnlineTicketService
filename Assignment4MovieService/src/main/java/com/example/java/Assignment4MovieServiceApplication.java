package com.example.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableAutoConfiguration
@EnableEurekaClient

public class Assignment4MovieServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Assignment4MovieServiceApplication.class, args);
		System.out.println("Spring Boot JPA movie-service started");
	}

}
