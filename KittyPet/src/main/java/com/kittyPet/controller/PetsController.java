package com.kittyPet.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kittyPet.models.Pets;
import com.kittyPet.service.PetsService;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/pets")
public class PetsController {
	
	@Autowired
	PetsService petsService;
		
	@PostMapping
	public ResponseEntity<Pets> createPet(@RequestBody Pets pets) {
		return petsService.createPet(pets);
		   
	}
	
	@GetMapping
	public ResponseEntity<List<Pets>> getAllPets() {
		return petsService.getAllPets();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Pets> deletePets(@PathVariable Long id){
		return petsService.deletePets(id);
	}
	
	@GetMapping(params = "name")
	public ResponseEntity<List<Pets>> searchPets(@RequestParam String name){
		return petsService.searchPets(name);
	}
	
}
