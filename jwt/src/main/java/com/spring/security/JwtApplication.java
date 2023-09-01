package com.spring.security;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity(debug = true) 
public class JwtApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication app = new SpringApplication(JwtApplication.class);
		//app.setDefaultProperties(Collections.singletonMap("server.port", "8000"));
		
		app.run(args);
	}
}
