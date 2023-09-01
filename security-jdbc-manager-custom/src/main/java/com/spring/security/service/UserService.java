 package com.spring.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.security.model.User;
import com.spring.security.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
    @Autowired
    @Qualifier("passwordEncoder")
    BCryptPasswordEncoder bCryptPasswordEncoder;
    
	public Iterable<User> getUsers() {
		return userRepository.findAll();
	}
	
	public void registerUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}
}
