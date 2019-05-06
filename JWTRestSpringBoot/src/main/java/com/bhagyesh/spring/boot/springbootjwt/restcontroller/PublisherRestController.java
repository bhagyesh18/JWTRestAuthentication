package com.bhagyesh.spring.boot.springbootjwt.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bhagyesh.spring.boot.springbootjwt.model.Category;
import com.bhagyesh.spring.boot.springbootjwt.model.Publisher;
import com.bhagyesh.spring.boot.springbootjwt.services.CategoryServices;
import com.bhagyesh.spring.boot.springbootjwt.services.PublisherServices;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class PublisherRestController {

	@Autowired
	private PublisherServices publishersService;
	
	@RequestMapping(method = RequestMethod.GET,value="/publishers")
	public List<Publisher> getAllPublisher() {
		return publishersService.getAllPublishers();
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/publishers/{id}")
	public Publisher getPublisher(@PathVariable Integer id) {
		return publishersService.getPublisher(id);
	}
	
	@RequestMapping(method = RequestMethod.POST,value="/publishers")
	public void addPublisher(@RequestBody Publisher publisher) {
		publishersService.addPublisher(publisher);;
	}
	
	@RequestMapping(method = RequestMethod.PUT,value="/publishers")
	public void updatePublisher(@RequestBody Publisher publisher) {
		  publishersService.updatePublisher(publisher);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value="/publishers/{id}")
	public void deletePublisher(@PathVariable Integer id) {
		publishersService.deletePublisher(id);
}
	
	
	
	
	
}
