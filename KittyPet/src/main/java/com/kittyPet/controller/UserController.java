package com.kittyPet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kittyPet.models.User;
import com.kittyPet.service.UserService;


@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		return userService.getAllUsers();
	}

}
