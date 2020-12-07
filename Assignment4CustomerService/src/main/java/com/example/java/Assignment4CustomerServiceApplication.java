package com.example.java;

import java.io.Console;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableAutoConfiguration
@EnableEurekaClient
public class Assignment4CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Assignment4CustomerServiceApplication.class, args);
		System.out.println("Spring JPA customer-service Started.....");
	}

}
