package com.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain getSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.cors().disable();
		httpSecurity.csrf().disable();
		httpSecurity.authorizeHttpRequests((auth) ->{
			auth.requestMatchers("/h2-console/**").permitAll();
			auth.requestMatchers("/user").permitAll();
		}).httpBasic(Customizer.withDefaults());
		
		return httpSecurity.build();
	}
	
	@Bean("passwordEncoder")
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
