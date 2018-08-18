package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.revature.beans.User;
import com.revature.services.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService ls;
	
	@PostMapping(value="/login")
	public ResponseEntity<User> authenticator(@RequestBody User user) {
		User u = ls.authenticate(user);
		return ResponseEntity.ok(u);
	}
}