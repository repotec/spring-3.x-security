package com.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain getSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity.authorizeHttpRequests((auth) -> {
						auth.requestMatchers(HttpMethod.POST, "/account").authenticated();
						auth.requestMatchers("/about").permitAll();
						auth.requestMatchers("/h2-console/**").permitAll();
						auth.anyRequest().authenticated();
				}).httpBasic(Customizer.withDefaults()).build();
	}

	@Bean
	public SecurityFilterChain getSecurityFilterChain2(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity.authorizeHttpRequests()
				           .requestMatchers("/h2-console/**", "about").permitAll()
				           .requestMatchers("/account").authenticated()
				           .anyRequest().authenticated()
				           .and()
				           .cors().disable()
				           .cors().disable()
				           .httpBasic(Customizer.withDefaults()).build();
	}


	@Bean("passwordEncoder")
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
