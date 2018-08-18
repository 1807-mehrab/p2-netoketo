package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.User;
import com.revature.repository.UserDao;

@Service
public class LoginService {
	@Autowired
	private UserDao dao;
	
	public User authenticate(User user) {
		return dao.authenticate(user);
	}

}
