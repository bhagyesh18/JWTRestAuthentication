package com.bhagyesh.spring.boot.springbootjwt.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bhagyesh.spring.boot.springbootjwt.model.Book;
import com.bhagyesh.spring.boot.springbootjwt.model.Category;
import com.bhagyesh.spring.boot.springbootjwt.services.BookServices;
import com.bhagyesh.spring.boot.springbootjwt.services.CategoryServices;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class BookRestController {

	@Autowired
	private BookServices bookService;
	
	@RequestMapping(method = RequestMethod.GET,value="/books")
	@PreAuthorize("hasRole('ADMIN')")
	public List<Book> getAllBook() {
		return bookService.getAllBooks();
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/books/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public Book getbook(@PathVariable Integer id) {
		return bookService.getBook(id);
	}
	
	@RequestMapping(method = RequestMethod.POST,value="/books")
	public void addBook(@RequestBody Book book) {
		bookService.addBook(book);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value="/books")
	public void updateBook(@RequestBody Book book) {
		  bookService.updateBook(book);;
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value="/b/{id}")
	public void deleteBook(@PathVariable Integer id) {
		bookService.deleteBook(id);
	}
	
	
	
	
	
}
