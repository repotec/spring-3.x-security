package com.spring.security.controller;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.model.User;
import com.spring.security.repository.UserRepository;

@RestController
public class LoginController {
	
	@Autowired
	UserRepository UserRepository;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ResponseEntity<User> doLogin(Principal principal){
		Optional<User> user = UserRepository.findByUsername(principal.getName());
		if(user.isPresent()) {
			return new ResponseEntity<User>(user.get(), HttpStatus.OK);
		}
		return new ResponseEntity<User>(new User(), HttpStatus.UNAUTHORIZED);
	}
}
