package com.bhagyesh.spring.boot.springbootjwt.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.bhagyesh.spring.boot.springbootjwt.model.Category;
import com.bhagyesh.spring.boot.springbootjwt.model.Publisher;
import com.bhagyesh.spring.boot.springbootjwt.repository.CategoryRepository;
import com.bhagyesh.spring.boot.springbootjwt.repository.PublisherRepository;

@Service
public class PublisherServices {

	@Autowired
	private PublisherRepository publshersRepo;
	
	public List<Publisher> getAllPublishers(){
		List<Publisher> publishersList=new ArrayList<Publisher>();
		publshersRepo.findAll().forEach(publishersList::add);
		return publishersList;
	}
	
	public Publisher getPublisher(@PathVariable Integer id) {
		return publshersRepo.findById(id).get();
	}
	
	public void addPublisher(Publisher publisher) {
		publshersRepo.save(publisher);
	}
	
	public void updatePublisher(Publisher publisher) {
		publshersRepo.save(publisher);
	}
	
	public void deletePublisher(Integer id) {
		publshersRepo.deleteById(id);
	}
	
}
