package com.cg.bookla.service;

import java.util.List;

import com.cg.bookla.dao.BookDao;
import com.cg.bookla.dao.BookDaoImpl;
import com.cg.bookla.entities.Book;

public class BookServiceImpl implements BookService {

	private BookDao dao;

	public BookServiceImpl() {
		dao = new BookDaoImpl();
	}

	@Override
	public Book getBookById(int id) {
		// TODO Auto-generated method stub
		return dao.getBookById(id);
	}

	@Override
	public List<Book> getAuthorBooks(String author) {
		// TODO Auto-generated method stub
		return dao.getAuthorBooks(author);
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return dao.getAllBooks();
	}

	@Override
	public List<Book> getBooksInPriceRange(double low, double high) {
		// TODO Auto-generated method stub
		return dao.getBooksInPriceRange(low, high);
	}

}
