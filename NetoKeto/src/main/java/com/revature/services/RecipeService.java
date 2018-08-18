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
	
	public void postRecipe(Recipe recipe) {
		dao.postRecipe(recipe);
	}

	public RecipeDao getDao() {
		return dao;
	}

	public void setDao(RecipeDao dao) {
		this.dao = dao;
	}
}
