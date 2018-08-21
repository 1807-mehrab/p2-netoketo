package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Image;
import com.revature.repository.ImageDao;

@Service
public class ImageService {
	@Autowired
	private ImageDao dao;

	public void setDao(ImageDao dao) {
		this.dao = dao;
	}
	
	public List<Image> getImagesByRecipe(int id) {
		return dao.getImagesByRecipe(id);
	}
	
	public void postImage(Image image) {
		dao.postImage(image);
	}
	
	public void updateImage(Image image) {
		dao.updateImage(image);
	}
}
