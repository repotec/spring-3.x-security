package com.spring.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.model.User;
import com.spring.security.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/user", method = RequestMethod.GET)
	public Iterable<User> getUsers() {		
		return userService.getUsers();
	}
	
	@RequestMapping(value="/user", method = RequestMethod.POST)
	public ResponseEntity<String> registerUsers(@RequestBody User user) {
		userService.registerUser(user);
		
		return new ResponseEntity<String>("new user has been created", HttpStatus.CREATED);
	}
}
