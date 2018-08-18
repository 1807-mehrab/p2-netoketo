package com.revature.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Recipe;

@Transactional
@Repository
public class RecipeDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Recipe> getAllRecipes() {
		Session s = sessionFactory.getCurrentSession();
		List<Recipe> recipes = s.createQuery("from Recipe").list();
		return recipes;
	}
	
	@Transactional
	public void postRecipe(Recipe recipe) {
		Session s = sessionFactory.getCurrentSession();
		s.save(recipe);
	}
}