package com.spring.security.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
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
		.and()
		.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
			   .csrfTokenRequestHandler(null)
			   .ignoringRequestMatchers("/card/**")
		.and()
        .authorizeHttpRequests((auth)->{
			auth.requestMatchers("/account").authenticated();
			auth.requestMatchers("/balance").authenticated();
			auth.requestMatchers("/notice").authenticated();

			auth.requestMatchers("/h2-console/**").permitAll();
			auth.requestMatchers("/about/**").permitAll();
			auth.requestMatchers("/about/new").permitAll();
			auth.requestMatchers("/contact/**").permitAll();
			auth.requestMatchers("/card/**").permitAll();
			auth.requestMatchers("/login").permitAll();
		}).sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		  .httpBasic(Customizer.withDefaults());
		
		return httpSecurity.build();
	}
	
	@Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        //config.setAllowedOrigins(Arrays.asList("http://localhost:5500", "http://127.0.0.1:5500"));
        config.setAllowedOriginPatterns(List.of("*"));
        config.setAllowedMethods(Collections.singletonList("*"));
        config.setAllowedHeaders(Collections.singletonList("*"));
        config.setExposedHeaders(Collections.singletonList("*"));
        config.setAllowCredentials(true);
        config.setMaxAge(6300L);
        
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        
        return source;
    }
}

