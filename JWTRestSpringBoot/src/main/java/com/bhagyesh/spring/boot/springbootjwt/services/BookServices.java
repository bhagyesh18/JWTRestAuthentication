package com.bhagyesh.spring.boot.springbootjwt.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.bhagyesh.spring.boot.springbootjwt.model.Book;
import com.bhagyesh.spring.boot.springbootjwt.repository.BookRepository;

@Service
public class BookServices {

	@Autowired
	private BookRepository bookRepo;
	
	public List<Book> getAllBooks(){
		List<Book> booksList=new ArrayList<Book>();
		bookRepo.findAll().forEach(booksList::add);
		return booksList;
	}
	
	public Book getBook(@PathVariable Integer id) {
		return bookRepo.findById(id).get();
		
	}
	
	public void addBook(Book book) {
		bookRepo.save(book);
	}
	
	public void updateBook(Book book) {
		bookRepo.save(book);
	}
	
	public void deleteBook(Integer id) {
		bookRepo.deleteById(id);
	}
	
}
