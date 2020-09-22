package com.kittyPet.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "pets")
public class Pets {
	
@Id
private Long id;
private Long price;
private String breed;
private String phone;
private String name;
private String url;
	
	
public Pets(Long id, Long price, String breed, String phone, String name, String url) {
	super();
	this.id = id;
	this.price = price;
	this.breed = breed;
	this.phone = phone;
	this.name = name;
	this.url = url;
}

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public long getPrice() {
	return price;
}
public void setPrice(Long price) {
	this.price = price;
}
public String getBreed() {
	return breed;
}
public void setBreed(String breed) {
	this.breed = breed;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}

@Override
public String toString() {
	return "Pets [id=" + id + ", name=" + name + ", price=" + price + ", phone=" + url + ", phone=" + url + "]";
}

}
