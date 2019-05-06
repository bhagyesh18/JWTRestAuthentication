package com.bhagyesh.spring.boot.springbootjwt.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.bhagyesh.spring.boot.springbootjwt.model.Category;
import com.bhagyesh.spring.boot.springbootjwt.repository.CategoryRepository;

@Service
public class CategoryServices {

	@Autowired
	private CategoryRepository categoryRepo;
	
	public List<Category> getAllCategories(){
		List<Category> categoriesList=new ArrayList<Category>();
		categoryRepo.findAll().forEach(categoriesList::add);
		return categoriesList;
	}
	
	public Category getCategory(@PathVariable String id) {
		return categoryRepo.findById(id).get();
	}
	
	public void addCategory(Category category) {
		categoryRepo.save(category);
	}
	
	public void updateCategory(Category category) {
		categoryRepo.save(category);
	}
	
	public void deleteCategory(String id) {
		categoryRepo.deleteById(id);
	}
	
}
