package com.example.bloodbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BloodBankRestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloodBankRestapiApplication.class, args);
		System.out.println("Bloodbank REST_API Started");
	}

}
