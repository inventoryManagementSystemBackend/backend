package com.keral.inventoryManagementSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "User")
@Entity
public class User {
	
	@Id
	@Column(name = " User_ID")
	private String user_id;
	@Column(name = "User_Name")
	private String user_name;
	@Column(name = "Roles")
	private String roles;
	@Column(name = "Email_ID")
	private String email;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
