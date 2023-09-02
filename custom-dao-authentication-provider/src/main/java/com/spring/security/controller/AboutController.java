package com.spring.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AboutController {

	@RequestMapping(value="/about", method = RequestMethod.GET)
	public String getAccount() {
		
		return "this is about!";
	}
}
