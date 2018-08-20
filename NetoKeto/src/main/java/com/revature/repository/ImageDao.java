package com.revature.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Image;

@Transactional
@Repository
public class ImageDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Image> getImagesByRecipe(int id) {
		Session s = sessionFactory.getCurrentSession();
		List<Image> images = s.createQuery("from Image where recipeid = :recipeid").setInteger("recipeid", id).list();
		return images;
	}
	
	public void postImage(Image image) {
		Session s = sessionFactory.getCurrentSession();
		s.save(image);
	}
}
