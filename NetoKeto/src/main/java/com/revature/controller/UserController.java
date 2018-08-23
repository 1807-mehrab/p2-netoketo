package com.revature.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.User;
import com.revature.services.UserService;

@CrossOrigin
@RestController
public class UserController {
	@Autowired
	private UserService us;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> users = us.getAllUsers();
		return ResponseEntity.ok(users);
	}
	
//	@GetMapping(value="/users")
//	public ResponseEntity<User> getRecipeById(
//			@RequestParam(value = "username", required = false) String un) {
//		System.out.println("Requesting: " + un);
//		User response = us.getUserByUsername(un);
//		return ResponseEntity.ok(response);
//		
//	}
	
	@GetMapping(value="/users/{username}")
	public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username) {
		User response = us.getUserByUsername(username);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping(value = "/users")
	public ResponseEntity<User> postUser(@RequestBody User user) {
		us.postUser(user);
		return ResponseEntity.ok(user);
	}
	
	@PutMapping(value= "/users")
	public ResponseEntity<User> updateUser(@Valid @RequestBody User user, Errors errors) {
		if (errors.hasErrors()) {
			return null;
		}
		us.updateUser(user);
		System.out.println("User: " + user.getUsername());
		User response = us.getUserByUsername(user.getUsername());
		return ResponseEntity.ok(response);
	}
	
	@PutMapping(value="/users/{username}")
	public ResponseEntity<User> updateUser2(@RequestBody User user,@PathVariable("username") String username) {
		//User response = us.getUserByUsername(username);
		System.out.println("User Put: " + user.getUsername());
		us.updateUser(user);
		return ResponseEntity.ok(user);
	}
	
//	@RequestMapping(value ="/users/{username}", method = RequestMethod.PATCH)
//	public ResponseEntity<User> updateUser3(@RequestBody User user,@PathVariable("username") String username) {
//		//User response = us.getUserByUsername(username);
//		System.out.println("User Patched: " + user.getUsername());
//		us.updateUser(user);
//		return ResponseEntity.ok(user);
//	}
//	
//	@RequestMapping(value = "/users", method = RequestMethod.PATCH)
//	public ResponseEntity<User> updateUser4(@Valid @RequestBody User user, Errors errors) {
//		if (errors.hasErrors()) {
//			return null;
//		}
//		us.updateUser(user);
//		System.out.println("User: " + user.getUsername());
//		User response = us.getUserByUsername(user.getUsername());
//		return ResponseEntity.ok(response);
//	}
	@DeleteMapping(value="/users/{username}")
	public ResponseEntity<User> deleteUser(@PathVariable("username") String username){
		System.out.println("Attempted Deletion: " + username);
		User del = us.getUserByUsername(username);
		us.deleteUser(del);
		return ResponseEntity.ok(del);
	}
}