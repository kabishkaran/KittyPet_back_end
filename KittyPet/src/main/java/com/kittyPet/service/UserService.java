package com.kittyPet.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kittyPet.models.User;
import com.kittyPet.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRep;

	public ResponseEntity<List<User>> getAllUsers() {
		try {
			List<User> user = new ArrayList<User>();
			
			userRep.findAll().forEach(user::add);
			
			if (user.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(user, HttpStatus.OK);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
