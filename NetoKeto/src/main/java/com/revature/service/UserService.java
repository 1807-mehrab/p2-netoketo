package com.revature.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.User;
import com.revature.repository.UserDao;

@Service
public class UserService {
	@Autowired
	UserDao dao;
	
	public void setDao(UserDao dao) {
		this.dao=dao;
	}
	
	@Transactional
	public List<User> getAll() {
		return dao.getUsers();
	}
}
