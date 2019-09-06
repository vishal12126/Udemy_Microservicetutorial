package com.rest.webservices.restfulwebservices.user;


import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserJPAResource {
	
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
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id){
		repository.deleteById(id);
	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
		User savedUser = repository.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{Id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	//Retrieve all post for User ID
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrieveAllUsers(@PathVariable int id) throws Exception{
		Optional<User> user = repository.findById(id);
		if(!user.isPresent())
		   throw new Exception("NO DATA Found");
		return user.get().getPost();
	}
}
