package com.bhagyesh.spring.boot.springbootjwt.model;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.*;

@Entity
public class Book {

	public Book() {
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_publisher",
        joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "publisher_id", referencedColumnName = "id"))
    private Set<Publisher> publishers;

    public Book(String name, Set<Publisher> publishers) {
        this.name = name;
        this.publishers = publishers;
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

	public Set<Publisher> getPublishers() {
		return publishers;
	}

	public void setPublishers(Set<Publisher> publishers) {
		this.publishers = publishers;
	}
    
    
    
}
