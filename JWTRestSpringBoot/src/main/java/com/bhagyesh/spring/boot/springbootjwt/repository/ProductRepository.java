package com.bhagyesh.spring.boot.springbootjwt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bhagyesh.spring.boot.springbootjwt.model.Category;
import com.bhagyesh.spring.boot.springbootjwt.model.Products;

public interface ProductRepository extends CrudRepository<Products, String> {
	public List<Products> findByCategoryId(String categoryId);
	
}
