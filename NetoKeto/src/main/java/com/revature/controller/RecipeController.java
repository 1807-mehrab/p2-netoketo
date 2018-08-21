package com.revature.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Recipe;
import com.revature.services.RecipeService;

@CrossOrigin
@RestController
public class RecipeController {
	@Autowired
	RecipeService rs;

	@GetMapping(value = "/recipes")
	public ResponseEntity<List<Recipe>> getAllRecipes() {
		List<Recipe> recipes = rs.getAllRecipes();
		return ResponseEntity.ok(recipes);
	}

	@PostMapping(value = "/recipes")
	public ResponseEntity<Recipe> postRecipe(@Valid @RequestBody Recipe recipe, Errors errors) {
		if (errors.hasErrors()) {
			return null;
		}
		recipe.setDateCreated(new java.sql.Date(System.currentTimeMillis()));
		rs.postRecipe(recipe);
		return ResponseEntity.ok(recipe);
	}

	@PutMapping(value = "/recipes")
	public ResponseEntity<Recipe> updateRecipe(@Valid @RequestBody Recipe recipe, Errors errors) {
		if (errors.hasErrors()) {
			return null;
		}
		rs.updateRecipe(recipe);
		return ResponseEntity.ok(recipe);
	}

	@GetMapping(value = "/recipes/{id}")
	public ResponseEntity<Recipe> getRecipeById(@PathVariable int id) {
		Recipe recipe = rs.getRecipeById(id);
		return ResponseEntity.ok(recipe);

	}

	//TODO: Order by most recent recipes
	@GetMapping(value = "/recipes/recent")
	public List<Recipe> getRecentRecipes(){
		List<Recipe> recentRecipes = rs.getRecipesOrderedByDate();
		return recentRecipes;
	}

	//TODO: Order by most popular recipes
	@GetMapping(value="/recipes/popular")
	public List<Recipe> getPopularRecipes(){
		List<Recipe> popularRecipes = rs.getRecipesOrderedByRating();
		return popularRecipes;
	}
}
