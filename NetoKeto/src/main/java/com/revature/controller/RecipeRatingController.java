package com.revature.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.RecipeRating;
import com.revature.services.RecipeRatingService;

@CrossOrigin
@RestController
public class RecipeRatingController {
	@Autowired
	private RecipeRatingService rrs;
	
	@GetMapping(value="/ratings/recipe/{id}")
	public ResponseEntity<List<RecipeRating>> getRecipeRatingsInRecipe(@PathVariable int id) {
		List<RecipeRating> ratings = rrs.getRecipeRatingsInRecipe(id);
		return ResponseEntity.ok(ratings);
	}
	
	@PostMapping(value="/ratings")
	public void postRecipeRating(@Valid @RequestBody RecipeRating recipeRating , Errors errors) {
		if (errors.hasErrors()) {
			return;
		}
		rrs.postRecipeRating(recipeRating);
	}
}
