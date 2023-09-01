package com.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.spring.security.filter.AfterLoginFilter;
import com.spring.security.filter.AuthenticationProgressFilter;
import com.spring.security.filter.BeforeRequestFilter;

@Configuration
public class SecurityConfig {
	@Bean
	public SecurityFilterChain config (HttpSecurity httpSecurity) throws Exception {
		httpSecurity
		.cors().disable()
		.addFilterBefore(new BeforeRequestFilter(), BasicAuthenticationFilter.class)
		.addFilterAfter(new AfterLoginFilter(), BasicAuthenticationFilter.class)
		.addFilterAt(new AuthenticationProgressFilter(), BasicAuthenticationFilter.class)
        .authorizeHttpRequests((auth)->{
			auth.requestMatchers("/account").authenticated();
			auth.requestMatchers("/h2-console/**").permitAll();
		}).httpBasic(Customizer.withDefaults());
		
		return httpSecurity.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}