package com.kittyPet.service;



import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kittyPet.models.Pets;
import com.kittyPet.repository.PetsRepCus;
import com.kittyPet.repository.PetsRepository;

@Service
public class PetsService {
	
@Autowired
PetsRepository petsRep;
	
@Autowired
PetsRepCus petRepCus;

public ResponseEntity<Pets> createPet(Pets pets) {
	long id =petRepCus.getMaxPetId() + 1;
		
		try {
			Pets newPet = petsRep.save(new Pets (id, pets.getPrice(), pets.getBreed(), pets.getPhone(),
					pets.getName(), pets.getUrl()));
			return new ResponseEntity<>(newPet, HttpStatus.CREATED);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
		
	}

	public ResponseEntity<List<Pets>> getAllPets() {
		try {
		    List<Pets> pets = new ArrayList<Pets>();
		
		    petsRep.findAll().forEach(pets::add);
		
		    if (pets.isEmpty()) {
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    }
		
		    return new ResponseEntity<>(pets, HttpStatus.OK);
		} catch (Exception e) {
		    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Pets> deletePets(Long id) {
		try {
			petsRep.deleteById(id);
			
//			List<Pets> idPets = new ArrayList<Pets>();
//			if (idPets.isEmpty()) {
//				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//				
//			}
			
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<List<Pets>> searchPets(String name) {
		try {
			List<Pets> pets = petsRep.searchPets(name);
			
			if (pets.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(pets, HttpStatus.OK);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	}
