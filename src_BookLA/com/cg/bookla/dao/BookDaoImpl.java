package com.cg.bookla.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.cg.bookla.entities.Book;

public class BookDaoImpl implements BookDao {

	private EntityManager entityManager;

	public BookDaoImpl() {
		entityManager = JPAUtil.getEntityManager();
	}

	@Override
	public Book getBookById(int id) {
		// TODO Auto-generated method stub
		Book book = entityManager.find(Book.class, id);
		return book;
	}
	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		Query query = entityManager.createNamedQuery("getAllBooks");
		@SuppressWarnings("unchecked")
		List<Book> bookList = query.getResultList();
		return bookList;
	}
	@Override
	public List<Book> getAuthorBooks(String author) {
		// TODO Auto-generated method stub
		String qStr = "SELECT book FROM Book book WHERE book.author=:pAuthor";
		TypedQuery<Book> query = entityManager.createQuery(qStr, Book.class);
		query.setParameter("pAuthor", author);
		List<Book> bookList = query.getResultList();
		return bookList;
	}

	@Override
	public List<Book> getBooksInPriceRange(double low, double high) {
		// TODO Auto-generated method stub
		String qStr = "SELECT book FROM Book book WHERE book.price between :low and :high";
		TypedQuery<Book> query = entityManager.createQuery(qStr, Book.class);
		query.setParameter("low", low);
		query.setParameter("high", high);
		List<Book> bookList = query.getResultList();
		return bookList;
	}
}
