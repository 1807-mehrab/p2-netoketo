package com.revature.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Comment;
import com.revature.services.CommentService;

@RestController
public class CommentController {
	@Autowired
	private CommentService cs;
	
	@GetMapping(value="/comments")
	public ResponseEntity<List<Comment>> getAllComments() {
		List<Comment> comments = cs.getAllComments();
		return ResponseEntity.ok(comments);
	}
	
	@GetMapping(value="/comments/recipe/{id}")
	public ResponseEntity<List<Comment>> getCommentsInRecipe(@PathVariable int id) {
		List<Comment> comments = cs.getCommentsInRecipe(id);
		return ResponseEntity.ok(comments);
	}
	
	@GetMapping(value="/comments/users/{id}")
	public ResponseEntity<List<Comment>> getCommentsByUser(@PathVariable int id) {
		List<Comment> comments = cs.getCommentsByUser(id);
		return ResponseEntity.ok(comments);
	}
	
	@PostMapping(value="/comments")
	public void postComment(@Valid @RequestBody Comment comment, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}
		cs.postComment(comment);
	}
}
