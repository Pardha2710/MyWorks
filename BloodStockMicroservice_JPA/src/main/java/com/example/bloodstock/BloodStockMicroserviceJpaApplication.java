package com.example.bloodstock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BloodStockMicroserviceJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloodStockMicroserviceJpaApplication.class, args);
		System.setProperty("spring.config.name", "bloodstock-web");
	    System.out.println("Bloodstock Micro Service Started....");
	}

}
