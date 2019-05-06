package com.bhagyesh.spring.boot.springbootjwt.repository;

import org.springframework.data.repository.CrudRepository;

import com.bhagyesh.spring.boot.springbootjwt.model.Category;

public interface CategoryRepository extends CrudRepository<Category, String> {
	
	
}
