package com.example.seeker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SeekerMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeekerMicroserviceApplication.class, args);
		System.setProperty("spring.config.name", "SeekerPatient-web");
	    System.out.println("Seeker Microservice has stared....");
	}

}
