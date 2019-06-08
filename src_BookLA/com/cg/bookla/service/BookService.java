package com.cg.bookla.service;

import java.util.List;

import com.cg.bookla.entities.Book;

public interface BookService {
	public abstract Book getBookById(int id);
	public abstract List<Book> getAuthorBooks(String author);
	public abstract List<Book> getAllBooks();
	public abstract List<Book> getBooksInPriceRange(double low, double high);
}
