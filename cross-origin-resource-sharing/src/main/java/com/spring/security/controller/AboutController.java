package com.spring.security.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/about")
public class AboutController {

	@RequestMapping(value="/get", method = RequestMethod.GET)
	public ResponseEntity<Map<String, String>> getAbout() {	
		return new ResponseEntity<Map<String, String>>(new HashMap<String, String>() {
			private static final long serialVersionUID = 1L;
		{ put("name", "ahmed"); }}, HttpStatus.OK);
	}
	
	/**
	 * this will cause POST http://127.0.0.1:8000/add 403 even we enable cors option
	 * this is because of post method that will change the data
	 * CSRF (CROSS-SITE REQUEST FORGERY) will raise 403 error
	 * @param message
	 * @return
	 */
	@RequestMapping(value="/new/{message}", method = RequestMethod.POST)
	public ResponseEntity<List<String>> addAccount(@PathVariable String message) {		
		return new ResponseEntity<>(Arrays.asList(new String[] {message}), HttpStatus.OK);
	}
}
