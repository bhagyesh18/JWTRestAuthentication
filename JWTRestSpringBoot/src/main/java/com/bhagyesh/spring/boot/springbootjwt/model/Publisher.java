package com.bhagyesh.spring.boot.springbootjwt.model;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Publisher {
		
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	    private String name;
	    private String description; 
	    
	    @ManyToMany(mappedBy = "publishers")
	    private Set<Book> books;

	    
	    
		public Publisher() {
		}

		public Publisher(Integer id, String name, String description) {
			super();
			this.id = id;
			this.name = name;
			this.description = description;
			this.books=this.books;
		}
		
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
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

	
	
	    
	    
}
