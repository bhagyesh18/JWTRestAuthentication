package com.bhagyesh.spring.boot.springbootjwt.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.bhagyesh.spring.boot.springbootjwt.model.Category;
import com.bhagyesh.spring.boot.springbootjwt.model.Products;
import com.bhagyesh.spring.boot.springbootjwt.repository.CategoryRepository;
import com.bhagyesh.spring.boot.springbootjwt.repository.ProductRepository;

@Service
public class ProductServices {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Products> getAllProdcuts(String categoryID){
		List<Products> productsList=new ArrayList<Products>();
		productRepository.findByCategoryId(categoryID).forEach(productsList::add);  
		return productsList;
	}
	
	public Products getProduct(@PathVariable String id) {
		return productRepository.findById(id).get();
	}
	
	public void addProduct(Products products) {
		productRepository.save(products);
	}
	
	public void updateProduct(Products products) {
		productRepository.save(products);
	}
	
	public void deleteProduct(String id) {
		productRepository.deleteById(id);
	}
	
}
