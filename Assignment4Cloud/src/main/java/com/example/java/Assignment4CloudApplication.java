package com.example.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Assignment4CloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(Assignment4CloudApplication.class, args);
		System.out.println("Spring Boot JPA server started");
	}

}
