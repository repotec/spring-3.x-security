package com.spring.security.model;

public class Card {
	private String cardNumber;
	private String name;
	private String expireDate;
	
	public Card() {
		super();
	}
	
	public Card(String cardNumber, String name, String expireDate) {
		super();
		this.cardNumber = cardNumber;
		this.name = name;
		this.expireDate = expireDate;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	
	
}
