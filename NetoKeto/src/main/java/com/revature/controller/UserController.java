package com.revature.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class UserController {
	@RequestMapping(value="/username", method=RequestMethod.GET)
	public ResponseEntity<String> usernameGet() {
		String username = "username here";
		return ResponseEntity.ok(username);
	}
}