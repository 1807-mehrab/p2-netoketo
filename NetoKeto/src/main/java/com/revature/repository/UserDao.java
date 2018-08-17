package com.revature.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.revature.beans.User;

public class UserDao {
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<User> getUsers() {
		Session s = sessionFactory.getCurrentSession();
		return s.createQuery("from Users").list();
	}
}
