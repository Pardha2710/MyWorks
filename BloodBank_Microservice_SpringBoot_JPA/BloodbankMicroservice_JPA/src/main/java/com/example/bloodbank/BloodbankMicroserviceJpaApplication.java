package com.example.bloodbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BloodbankMicroserviceJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloodbankMicroserviceJpaApplication.class, args);
		System.setProperty("spring.config.name", "bloodbank-web");
	    System.out.println("Bloodbank Microservice Started....");
	}

}
