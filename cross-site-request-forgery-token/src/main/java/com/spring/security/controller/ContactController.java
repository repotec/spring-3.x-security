package com.spring.security.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.model.Contact;

@RestController
public class ContactController {
	@RequestMapping(value="/contact", method = RequestMethod.POST)
	public Contact getAccount(@RequestBody Contact contact) {
		return contact;
	}
}
