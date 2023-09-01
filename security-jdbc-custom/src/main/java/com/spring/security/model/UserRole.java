package com.spring.security.model;

import jakarta.persistence.*;
@Entity
@Table(name = "user_roles")
public class UserRole {
	@Id
	@Column(name = "user_role_id")
	private Integer userRoleId;
	
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "role_id")
	private Integer roleId;

	@ManyToOne
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "role_id", insertable = false, updatable = false)
	private Role role;
	
	public UserRole() {
		super();
	}
	
	public UserRole(Integer userRoleId, Integer userId, Integer roleId) {
		super();
		this.userRoleId = userRoleId;
		this.userId = userId;
		this.roleId = roleId;
	}

	public Integer getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
