package com.spring.security.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain getSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeHttpRequests((auth) ->{
			auth.requestMatchers("/account").authenticated();
			auth.requestMatchers("/about").permitAll();
			auth.requestMatchers("/h2-console/**").permitAll();
		}).httpBasic(Customizer.withDefaults());
		
		return httpSecurity.build();
	}
	
	@Bean
	public UserDetailsService getUserDetailsService(DataSource datasource) throws SQLException {
		return new JdbcUserDetailsManager(datasource);
	}
	
	@Bean("passwordEncoder")
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
