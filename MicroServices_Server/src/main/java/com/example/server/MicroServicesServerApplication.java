package com.example.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroServicesServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServicesServerApplication.class, args);
		System.out.println("Microservices server started......");
	}

}
