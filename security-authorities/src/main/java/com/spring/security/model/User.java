package com.spring.security.model;

import java.util.List;

import jakarta.persistence.*;
@Entity
@Table(name = "users")
@NamedEntityGraph(name = "users-graph",
attributeNodes = @NamedAttributeNode(value = "userRoles", subgraph = "role-subgraph"),
			subgraphs = @NamedSubgraph(name = "role-subgraph", attributeNodes = @NamedAttributeNode("role")))
public class User {
	@Id
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "user_name")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "enabled")
	private String enabled;
	
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	private List<UserRole> userRoles;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	public List<UserRole> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
}
