package com.bhagyesh.spring.boot.springbootjwt.repository;

import org.springframework.data.repository.CrudRepository;

import com.bhagyesh.spring.boot.springbootjwt.model.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
	
	
}
