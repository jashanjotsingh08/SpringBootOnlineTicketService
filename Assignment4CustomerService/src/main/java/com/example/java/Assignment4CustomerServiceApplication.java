package com.example.java;

import java.io.Console;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class Assignment4CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Assignment4CustomerServiceApplication.class, args);
		System.out.println("Spring JPA customer-service Started.....");
	}

}
