package com.bhagyesh.spring.boot.springbootjwt.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bhagyesh.spring.boot.springbootjwt.model.Category;
import com.bhagyesh.spring.boot.springbootjwt.services.CategoryServices;


@RestController
@RequestMapping("/api")
public class CategoryRestController {

	@Autowired
	private CategoryServices categoryService;
	
	@RequestMapping(method = RequestMethod.GET,value="/categories")
	public List<Category> getAllCategories() {
		return categoryService.getAllCategories();
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/categories/{id}")
	public Category getCategory(@PathVariable String id) {
		return categoryService.getCategory(id);
	}
	
	@RequestMapping(method = RequestMethod.POST,value="/categories")
	public void addCategories(@RequestBody Category category) {
		categoryService.addCategory(category);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value="/categories")
	public void updateCategories(@RequestBody Category category) {
		  categoryService.updateCategory(category);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value="/categories/{id}")
	public void deleteaddCategories(@PathVariable String id) {
		categoryService.deleteCategory(id);
	}
	
	
	
	
	
}
