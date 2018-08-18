package com.revature.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.User;
import com.revature.services.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService us;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<String> getAllUsers(){
		String users = us.getAllUsers().toString();
		return ResponseEntity.ok(users);
	}
	
	@GetMapping(value="/users/{username}")
	public ResponseEntity<String> getUserByUsername(@PathVariable("username") String username) {
		String response = us.getUserByUsername(username).toString();
		return ResponseEntity.ok(response);
	}
	
	@PostMapping(value = "/users")
	public void postUser(@Valid @RequestBody User user, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}
		us.postUser(user);
	}
}