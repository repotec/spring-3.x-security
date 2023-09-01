package com.spring.security;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EntityScan("com.spring.security.model")
@EnableWebSecurity(debug = true)
public class CustomFilterApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication app = new SpringApplication(CustomFilterApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "8000"));
		
		app.run(args);
	}
}
