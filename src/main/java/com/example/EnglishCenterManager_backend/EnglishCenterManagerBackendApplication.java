package com.example.EnglishCenterManager_backend;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EnglishCenterManagerBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnglishCenterManagerBackendApplication.class, args);
		
	}

	@Bean
	public ModelMapper ModelMapper(){
		return new ModelMapper();
	}

}
