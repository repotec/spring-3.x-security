package com.spring.security.service;

import com.spring.security.dto.CustomUserDetails;
import com.spring.security.model.User;
import com.spring.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> customer = userRepository.findByUsername(email);
		
		if(customer.isPresent()) {
			return new CustomUserDetails(customer.get());
		}else {
			throw new UsernameNotFoundException("Username Not Found Exception");
		}
	}
}
