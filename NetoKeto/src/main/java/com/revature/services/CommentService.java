package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Comment;
import com.revature.repository.CommentDao;

@Service
public class CommentService {
	@Autowired
	private CommentDao dao;
	
	public void setDao(CommentDao dao) {
		this.dao = dao;
	}

	public List<Comment> getAllComments() {
		return dao.getAllComments();
	}
	
	public List<Comment> getCommentsInRecipe(int id) {
		return dao.getCommentsInRecipe(id);
	}
	
	public List<Comment> getCommentsByUser(int id) {
		return dao.getCommentsByUser(id);
	}
	
	public void postComment(Comment comment) {
		dao.postComment(comment);
	}
}
