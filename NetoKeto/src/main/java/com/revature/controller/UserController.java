package com.revature.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
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
	
	@GetMapping(value="/users/{username}")
	public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username) {
		User response = us.getUserByUsername(username);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping(value = "/users")
	public ResponseEntity<User> postUser(@RequestBody String inpt) {
		inpt = inpt.replaceFirst("\"user\":", "");
		inpt = inpt.substring(1);
		inpt = inpt.substring(0, (inpt.length()-1));
		ObjectMapper mapper = new ObjectMapper();
		User auth = new User();
		try {
			auth = mapper.readValue(inpt, User.class);;
		} catch (IOException e) {
			e.printStackTrace();
		}
		us.postUser(auth);
		return ResponseEntity.ok(auth);
	}
}