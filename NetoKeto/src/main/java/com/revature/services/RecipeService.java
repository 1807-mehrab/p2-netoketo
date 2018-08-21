package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Recipe;
import com.revature.repository.RecipeDao;

@Service
public class RecipeService {
	@Autowired
	private RecipeDao dao;
	
	public List<Recipe> getAllRecipes() {
		return dao.getAllRecipes();
	}
	
	public Recipe getRecipeById(int id) {
		return dao.getRecipeByID(id);
	}
	
	public void postRecipe(Recipe recipe) {
		dao.postRecipe(recipe);
	}

	public List<Recipe> getRecipesOrderedByDate() { return dao.getRecipesOrderByMostRecent(); }

	public List<Recipe> getRecipesOrderedByRating() { return dao.getRecipesByMostPopular(); }

	public RecipeDao getDao() {
		return dao;
	}

	public void setDao(RecipeDao dao) {
		this.dao = dao;
	}
}
