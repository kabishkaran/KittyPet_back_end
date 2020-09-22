package com.kittyPet.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.kittyPet.models.Pets;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.domain.Sort;


@Repository
public class PetsRepCusImpl implements PetsRepCus{
		
@Autowired
 MongoTemplate mongoTemplate;
	 
 public long getMaxPetId() {
	 Query query = new Query();
	 query.with(Sort.by(Sort.Direction.DESC, "id"));
	 query.limit(1);
	 Pets maxObject = mongoTemplate.findOne(query, Pets.class);
	 if (maxObject == null) {
	         return 0L;
	        }
	         return maxObject.getId();
 }
 }
