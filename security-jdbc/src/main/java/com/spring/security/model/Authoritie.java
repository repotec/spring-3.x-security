package com.spring.security.model;

import jakarta.persistence.*;

@Entity
@Table(name = "authorities")
public class Authoritie {
	@Id
	private int id;
	private String username;
	private String authority;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
}
