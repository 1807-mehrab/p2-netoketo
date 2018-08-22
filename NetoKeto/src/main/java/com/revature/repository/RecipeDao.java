package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
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

	/**
	 * Takes in a list of ingredients delimited by commas and returns a list of recipes containing all matching ingredients
	 * @param ingredients
	 * @return
	 */
	public List<Recipe> getRecipesByIngredients(String ingredients){
		Session s = sessionFactory.getCurrentSession();
		String[] listOfIngredients = ingredients.split(",");
		StringBuilder query = new StringBuilder("from Recipe recipe where");
		for(int i = 0; i < listOfIngredients.length; i++){
			if(i != 0){
				query.append((" and"));
			}
			query.append(" lower(recipe.ingredients) like :ingredient").append(i);
		}

		Query q = s.createQuery(query.toString());

		for(int i = 0; i < listOfIngredients.length; i++){
			q.setParameter("ingredient"+i, "%"+listOfIngredients[i].trim()+"%");
		}

		return q.list();
	}

	
	public Recipe getRecipeByID(int id) {
		Session s = sessionFactory.getCurrentSession();
		return (Recipe)s.createQuery("from Recipe where recipeId = :recipeId").setInteger("recipeId",id).list().get(0);
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