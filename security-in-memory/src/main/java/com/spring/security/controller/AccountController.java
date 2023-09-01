package com.spring.security.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

	@RequestMapping(value="/account", method = RequestMethod.GET)
	public List<String> getAccount() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		System.out.println(authentication.getAuthorities());

		return new ArrayList<String>(){
			private static final long serialVersionUID = 1L;
			{add("account1");
			add("account2");
			add("account3");}};
	}
}
