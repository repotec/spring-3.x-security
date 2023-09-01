package com.spring.security.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {
	@RequestMapping(value="/balance", method = RequestMethod.POST)
	public List<String> getAccount() {
		
		return new ArrayList<String>(){
			private static final long serialVersionUID = 1L;
			{add("100");
			add("200");
			add("490");}};
	}
}
