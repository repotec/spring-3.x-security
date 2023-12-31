package com.spring.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AccountController {

	@RequestMapping(value="/account", method = RequestMethod.GET)
	public List<String> getAccount() {
		
		return new ArrayList<String>(){
			private static final long serialVersionUID = 1L;
			{add("account1");
			add("account2");
			add("account3");}};
	}
}
