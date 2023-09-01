package com.spring.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.model.User;

@RestController
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void dologin(User user) {
		System.out.println("hello");
	}
}
