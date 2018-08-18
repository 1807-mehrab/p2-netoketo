package com.revature.services;

import com.revature.repository.UserDao;
import com.revature.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public UserDao getDao()
    {
        return dao;
    }

    public void setDao(UserDao dao)
    {
        this.dao = dao;
    }
}
