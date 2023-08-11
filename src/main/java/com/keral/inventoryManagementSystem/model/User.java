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
}
