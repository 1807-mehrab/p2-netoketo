package com.revature.repository;

import java.util.ArrayList;
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
	
	public Recipe getRecipeByID(int id) {
		Session s = sessionFactory.getCurrentSession();
		return (Recipe)s.createQuery("from Recipe where recipeId = :recipeId").setInteger("recipeID",id).list().get(0); 
	}
	
	@Transactional
	public void postRecipe(Recipe recipe) {
		Session s = sessionFactory.getCurrentSession();
		s.save(recipe);
	}

	public List<Recipe> getRecipesOrderByMostRecent (){
		Session s = sessionFactory.getCurrentSession();
		List<Recipe> recipes = s.createQuery("from Recipe order by dateCreated desc").list();
		return recipes;
	}

	public List<Recipe> getRecipesByMostPopular(){
		Session s = sessionFactory.getCurrentSession();
		List<Object[]> results = s.createQuery("select recipe.id, sum(rating.valNum)" +
				" from Recipe recipe" +
				"	join recipe.recipeRatings rating" +
				" group by recipe" +
				" order by sum(rating.valNum) desc").list();
		List<Recipe> recipes = new ArrayList<>();
		for(Object[] result : results){
			System.out.println("Results: " + result[0]);
			recipes.add((Recipe) s.get(Recipe.class, (int)result[0]));
		}
		return recipes;
	}


	public void updateRecipe(Recipe recipe) {
		Session s = sessionFactory.getCurrentSession();
		s.merge(recipe);
	}
}