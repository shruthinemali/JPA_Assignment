package com.cg.jpabook.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "author_master")
public class Author implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	@Column(name = "author_name")
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "book_author", joinColumns = { @JoinColumn(name = "author_id") }, inverseJoinColumns = { @JoinColumn(name = "book_isbn") })
	private Set<Book> Book = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Book> getBook() {
		return Book;
	}

	public void setBook(Set<Book> book) {
		Book = book;
	}

	public void addBook(Book book) {
		// TODO Auto-generated method stub
		this.getBook().add(book);
	}
	
	
}
