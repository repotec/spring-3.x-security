package com.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean("securityFilterChain")
	public SecurityFilterChain getSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeHttpRequests((auth)->{
				auth.requestMatchers("/account").hasRole("ADMIN");
				auth.requestMatchers("/about").permitAll();
		}).httpBasic(Customizer.withDefaults());
		
		return httpSecurity.build();
	}
	
	@Bean("userDetailsService")
	public InMemoryUserDetailsManager getUserDetailsService() {
		InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
		
		UserDetails admin = User.withUsername("admin").password("admin").roles("ROLE_ADMIN").build();
		UserDetails guest = User.withUsername("guest").password("admin").roles("ROLE_GUEST").build();
		
		userDetailsService.createUser(admin);
		userDetailsService.createUser(guest);
		
		return userDetailsService;
	}
	
	@Bean("passwordEncoder")
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
