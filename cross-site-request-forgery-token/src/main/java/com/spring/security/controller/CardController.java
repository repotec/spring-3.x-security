package com.spring.security.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.model.Card;

@RestController
public class CardController {
	
	@RequestMapping(value = "/card", method = RequestMethod.GET)
	public Card getCard() {
		return new Card("4444-8888-3333-9999", "ahmed mohammed", "07/26");
	}
	
	@RequestMapping(value = "/card", method = RequestMethod.POST)
	public Card putCard(@RequestBody Card card) {
		return card;
	}
}
