package com.spring.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity(debug = true) 
public class JwtApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(JwtApplication.class, args);
	}
}
