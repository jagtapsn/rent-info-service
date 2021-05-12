package com.teliacompany.task.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@SpringBootApplication
@EnableWebSecurity
public class RentInformationApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentInformationApplication.class, args);
	}

}
