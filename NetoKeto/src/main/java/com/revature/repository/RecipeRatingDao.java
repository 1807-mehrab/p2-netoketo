package com.revature.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.RecipeRating;

@Transactional
@Repository
public class RecipeRatingDao {
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<RecipeRating> getRecipeRatingsInRecipe(int id) {
		Session s = sessionFactory.getCurrentSession();
		List<RecipeRating> ratings = s.createQuery("from RecipeRating where recipeid = :recipeid").setInteger("recipeid", id).list();
		return ratings;
	}
	
	public void postRecipeRating(RecipeRating recipeRating) {
		Session s = sessionFactory.getCurrentSession();
		s.save(recipeRating);
	}
	
	public void updateRecipeRating(RecipeRating recipeRating) {
		Session s = sessionFactory.getCurrentSession();
		s.update(recipeRating);
	}
}
