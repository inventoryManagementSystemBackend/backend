package com.keral.inventoryManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keral.inventoryManagementSystem.model.User;
import com.keral.inventoryManagementSystem.service.UserManagementService;

@RestController
@RequestMapping("/inventory")
public class UserController {
	
	@Autowired
	private UserManagementService userService;

//	public UserController(UserManagementService userService) {
//		super();
//		this.userService = userService;
//	}
	
	@PostMapping("/user")
	public ResponseEntity<User> save(@RequestBody User u) {
		User user = userService.save(u);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
}
