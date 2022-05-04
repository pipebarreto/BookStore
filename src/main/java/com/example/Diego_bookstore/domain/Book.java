package com.example.Diego_bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String title;
	private String author;
	private int year;
	private String ISBN;
	private float price;
	
	@ManyToOne
	 @JoinColumn(name = "categoryId")
	 private Category category;
	
	
	public Book() {
		
	}
	public Book (String title, String author, int year, String ISBN, Category category) {		
		this.title=title;
		this.author=author;
		this.year=year;
		this.ISBN=ISBN;
		this.category=category;
	}
	
	public Book (String title, String author, int year, String ISBN) {
		this.title=title;
		this.author=author;
		this.year=year;
		this.ISBN=ISBN;
	}

	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	public Long getId() {
		return id;
	}
	
	public String toString() {
		return "Title: " + title + ". author: "+ author + ". year: "+ year +", id: "+id
				+ "category: " + category;
	}
	
}
