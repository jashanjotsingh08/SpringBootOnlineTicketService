package com.example.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class Assignment4MovieServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Assignment4MovieServiceApplication.class, args);
		System.out.println("Spring Boot JPA movie-service started");
	}

}
