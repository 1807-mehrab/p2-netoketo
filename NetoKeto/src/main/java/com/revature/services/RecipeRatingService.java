package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.RecipeRating;
import com.revature.repository.RecipeRatingDao;

@Service
public class RecipeRatingService {
	@Autowired
	private RecipeRatingDao dao;
	
	public void setDao(RecipeRatingDao dao) {
		this.dao = dao;
	}
	
	public List<RecipeRating> getRecipeRatingsInRecipe(int id) {
		return dao.getRecipeRatingsInRecipe(id);
	}
	
	public List<RecipeRating> getAllRecipeRatings() {
		return dao.getAllRecipeRatings();
	}
	
	public void postRecipeRating(RecipeRating recipeRating) {
		dao.postRecipeRating(recipeRating);
	}
	
	public void updateRecipeRating(RecipeRating recipeRating) {
		dao.updateRecipeRating(recipeRating);
	}

}
