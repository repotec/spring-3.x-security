package com.spring.security;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecurityJdbcApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication app = new SpringApplication(SecurityJdbcApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "8000"));
		
		app.run(args);
	}
}
