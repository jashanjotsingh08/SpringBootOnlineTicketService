package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Assignment4TicketServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Assignment4TicketServiceApplication.class, args);
		System.out.println("Spring Boot JPA ticket-service started");
		System.setProperty("spring.config.name", "ticket-service");
	}

}
