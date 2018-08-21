package com.revature.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Comment;

@Transactional
@Repository
public class CommentDao {
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Comment> getAllComments() {
		Session s = sessionFactory.getCurrentSession();
		List<Comment> comments = s.createQuery("from Comment").list();
		return comments;
	}
	
	public List<Comment> getCommentsInRecipe(int id) {
		Session s = sessionFactory.getCurrentSession();
		List<Comment> comments = s.createQuery("from Comment where recipeid = :recipeid").setInteger("recipeid", id).list();
		return comments;
	}
	
	public List<Comment> getCommentsByUser(int id) {
		Session s = sessionFactory.getCurrentSession();
		List<Comment> comments = s.createQuery("from Comment where ownerid = :ownerid").setInteger("ownerid", id).list();
		return comments;
	}
	
	public void postComment(Comment comment) {
		Session s = sessionFactory.getCurrentSession();
		s.save(comment);
	}
	
	public void updateComment(Comment comment) {
		Session s = sessionFactory.getCurrentSession();
		s.update(comment);
	}
}
