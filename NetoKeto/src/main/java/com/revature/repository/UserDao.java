package com.revature.repository;

import com.revature.beans.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class UserDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    public List<User> getUsers(){
        Session s = sessionFactory.getCurrentSession();
        return s.createQuery("from User").list();
    }
    
    public User getUserByUsername(String username) {
    	Session s = sessionFactory.getCurrentSession();
    	return (User)s.createQuery("from User where username = :username").setString("username", username).list().get(0);
    }
    
    @Transactional
    public void postUser(User user) {
    	Session s = sessionFactory.getCurrentSession();
    	System.out.println(user);
    	s.save(user);
    }
    
    public User authenticate(User user) {
    	Session s = sessionFactory.getCurrentSession();
    	List<User> users = s.createQuery("from User where username = :username and password = :password").setString("username", user.getUsername()).setString("password", user.getPassword()).list();
    	if (users.size() != 1) {
    		user = null;
    	} else {
    		user = users.get(0);
    	}
    	return user;
    }
}
