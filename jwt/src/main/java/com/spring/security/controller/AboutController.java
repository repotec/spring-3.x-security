package com.spring.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/about")
public class AboutController {

	@GetMapping
	public String getAbout() {
		return "about information - not premitted endpoint";
	}
	
	@PostMapping
	public String portAbout() {
		return "about information - premitted endpoint";
	}
}
