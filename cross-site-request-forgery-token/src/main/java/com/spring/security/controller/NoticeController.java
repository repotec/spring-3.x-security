package com.spring.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticeController {
	@RequestMapping(value="/notice", method = RequestMethod.GET)
	public String getNotice() {
		return "test";
	}
}
