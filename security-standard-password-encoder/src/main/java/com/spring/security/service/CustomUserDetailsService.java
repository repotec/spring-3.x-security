package com.spring.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.security.config.CustomUserDetails;
import com.spring.security.model.Customer;
import com.spring.security.repository.CustomerRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Customer> customer = customerRepository.findByEmail(email);
		
		if(customer.isPresent()) {
			return new CustomUserDetails(customer.get());
		}else {
			throw new UsernameNotFoundException("Username Not Found Exception");
		}
	}
}
