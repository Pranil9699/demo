package com.Hospital_management.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int Id;
   
   private String username;
   
   private String password;
   
   private String email;
   
   public User() {
       
   }

public int getId() {
	return Id;
}

public void setId(int id) {
	Id = id;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public User(int id, String username, String password, String email) {
	super();
	Id = id;
	this.username = username;
	this.password = password;
	this.email = email;
}
   

}
