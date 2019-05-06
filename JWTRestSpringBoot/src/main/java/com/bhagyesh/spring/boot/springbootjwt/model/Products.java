package com.bhagyesh.spring.boot.springbootjwt.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Products{

	public Products() {
		
	}

	@Id
	private String id;
	private String name;
	private String description;
	private BigDecimal quantity;
    private BigDecimal price;
    
    @ManyToOne
    private Category category;
    
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Products(String id, String name, String description, BigDecimal quantity, BigDecimal price,Category category) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
		this.category=category;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
    
    
}
