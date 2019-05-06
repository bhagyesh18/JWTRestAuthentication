package com.bhagyesh.spring.boot.springbootjwt.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bhagyesh.spring.boot.springbootjwt.model.Category;
import com.bhagyesh.spring.boot.springbootjwt.model.Products;
import com.bhagyesh.spring.boot.springbootjwt.services.CategoryServices;
import com.bhagyesh.spring.boot.springbootjwt.services.ProductServices;


@RestController
@RequestMapping("/api")
public class ProductRestController {

	@Autowired
	private ProductServices productsService;
	
	@RequestMapping(method = RequestMethod.GET,value="/categories/{categoryId}/products")
	public List<Products> getAllProducts(@PathVariable String categoryId) {
		return productsService.getAllProdcuts(categoryId);
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/categories/{categoryId}/products/{id}")
	public Products getProducts(@PathVariable String id) {
		return productsService.getProduct(id);
	}
	
	@RequestMapping(method = RequestMethod.POST,value="/categories/{categoryId}/products")
	public void addProducts(@RequestBody Products products,@PathVariable String categoryId) {
		products.setCategory(new Category(categoryId, "", ""));
		productsService.addProduct(products);;
	}
	
	@RequestMapping(method = RequestMethod.PUT,value="/categories/{categoryId}/produtcs/{id}")
	public void updateProducts(@RequestBody Products products,@PathVariable String categoryId,@PathVariable String id ) {
		products.setCategory(new Category(categoryId, "", ""));  
		productsService.updateProduct(products);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value="/categories/{categoryId}/products/{id}")
	public void deleteProducts(@PathVariable String categoryId,@PathVariable String id) {
		productsService.deleteProduct(id);
	}
	
	
	
	
	
}
