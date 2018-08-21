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

import com.revature.beans.Image;
import com.revature.services.ImageService;

@CrossOrigin
@RestController
public class ImageController {
	@Autowired
	private ImageService is;
	
	@GetMapping(value="/image/recipe/{id}")
	public ResponseEntity<List<Image>> getImagesByRecipe(@PathVariable int id) {
		List<Image> images = is.getImagesByRecipe(id);
		return ResponseEntity.ok(images);
	}
	
	@PostMapping(value="/image")
	public void postImage(@Valid @RequestBody Image image, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}
		is.postImage(image);
	}
}