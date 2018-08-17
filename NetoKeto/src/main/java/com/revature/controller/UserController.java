package com.revature.controller;

import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class UserController {
	@Autowired
	private UserService us;

	@RequestMapping(value="/username", method=RequestMethod.GET)
	public ResponseEntity<String> usernameGet() {
		String username = "username here";
		return ResponseEntity.ok(username);
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<String> getAllUsers(){
		String users = us.getAllUsers().toString();
		return ResponseEntity.ok(users);
	}
}