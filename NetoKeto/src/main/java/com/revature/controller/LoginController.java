package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.User;
import com.revature.services.LoginService;

@RestController
public class LoginController {
	@Autowired
	private LoginService ls;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<User> authenticator(@RequestBody User user) {
		System.out.print("Requested");
		System.out.print(user);
		User u = ls.authenticate(user);
		return ResponseEntity.status(HttpStatus.OK)
				//.header("status","200")
				.body(u);
	}
	
	@GetMapping(value="/login")
	public ResponseEntity<User> getRecipeById(
			@RequestParam(value = "username", required = false) String un, 
			@RequestParam(value = "password", required = false) String pw) {
		User auth = new User();
		auth.setUsername(un);
		auth.setPassword(pw);
		System.out.println("Requesting: " + un);
		User u = ls.authenticate(auth);
		return ResponseEntity.ok(u);
		
	}
	
	
}