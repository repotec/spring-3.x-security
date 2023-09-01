package com.spring.security.config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig {
	@Bean
	public SecurityFilterChain config (HttpSecurity httpSecurity) throws Exception {
		httpSecurity
		.cors().configurationSource(corsConfigurationSource())
		.and().csrf().disable()
        .authorizeHttpRequests((auth)->{
			auth.requestMatchers("/account").authenticated();
			auth.requestMatchers("/balance").authenticated();
			auth.requestMatchers("/h2-console/**").permitAll();
			auth.requestMatchers("/about/**").permitAll();
			auth.requestMatchers("/about/new").permitAll();
			auth.requestMatchers("/contact/**").permitAll();
		}).httpBasic(Customizer.withDefaults());
		
		return httpSecurity.build();
	}
	
	@Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Arrays.asList("http://localhost:5500", "http://127.0.0.1:5500"));
        //config.setAllowedOriginPatterns(Arrays.asList("*"));
        config.setAllowedMethods(Collections.singletonList("*"));
        config.setAllowedHeaders(Collections.singletonList("*"));
        config.setExposedHeaders(Collections.singletonList("*"));
        config.setAllowCredentials(true);
        config.setMaxAge(6300L);
        
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        
        return source;
    }
	
	@Bean("passwordEncoder")
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

//https://github.com/eazybytes/spring-security/blob/main/section6/springsecsection6latest/src/main/java/com/eazybytes/config/ProjectSecurityConfig.java
