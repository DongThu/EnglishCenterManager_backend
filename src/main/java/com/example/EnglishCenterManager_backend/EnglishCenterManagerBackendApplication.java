package com.example.EnglishCenterManager_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
public class EnglishCenterManagerBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnglishCenterManagerBackendApplication.class, args);
		
	}

}
