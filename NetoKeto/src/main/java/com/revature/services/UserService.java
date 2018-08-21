package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.User;
import com.revature.repository.UserDao;

@Service
public class UserService {
    @Autowired
    UserDao dao;

    public List<User> getAllUsers(){
        return dao.getUsers();
    }
    
    public User getUserByUsername(String username) {
    	return dao.getUserByUsername(username);
    }
    
    public void postUser(User user) {
    	dao.postUser(user);
    }
    
    public void updateUser(User user) {
    }

    public UserDao getDao()
    {
        return dao;
    }

    public void setDao(UserDao dao)
    {
        this.dao = dao;
    }
}
