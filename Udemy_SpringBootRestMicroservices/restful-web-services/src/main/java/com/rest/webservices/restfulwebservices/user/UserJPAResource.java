package com.rest.webservices.restfulwebservices.user;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserJPAResource {

	@Autowired
	private UserDaoService service;
	
	@Autowired
	private UserRepository repository;
	
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers(){
		return repository.findAll();
	}
	
	@GetMapping("/jpa/users/{id}")
	public Optional<User> retrieveUser(@PathVariable int id) throws Exception{
		Optional<User> user = repository.findById(id);
		if(!user.isPresent()){
			throw new Exception("User not found");
		}
		return user;
		
	}
}
