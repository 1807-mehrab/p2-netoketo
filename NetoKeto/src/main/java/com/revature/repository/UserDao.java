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
}
