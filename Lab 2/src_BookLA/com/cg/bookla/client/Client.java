package com.cg.bookla.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cg.bookla.entities.Book;
import com.cg.bookla.service.BookService;
import com.cg.bookla.service.BookServiceImpl;

public class Client {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		Book AutoBiography = new Book();
		AutoBiography.setId(100);
		AutoBiography.setTitle("ABC");
		AutoBiography.setAuthor("PQR");
		AutoBiography.setPrice(450d);
		
		Book Philosopy = new Book();
		Philosopy.setId(101);
		Philosopy.setTitle("DEF");
		Philosopy.setAuthor("STU");
		Philosopy.setPrice(520d);
		
		Book Fiction = new Book();
		Fiction.setId(102);
		Fiction.setTitle("DEF");
		Fiction.setAuthor("STU");
		Fiction.setPrice(580d);
		
		em.persist(AutoBiography);
		em.persist(Philosopy);
		em.persist(Fiction);
		
		BookService service = new BookServiceImpl();
		System.out.println("                 List of All books                ");
		for(Book book:service.getAllBooks()) {
			System.out.println(book);
		}
		System.out.println("                Listing book written by ABC              ");
		for(Book book:service.getAuthorBooks("ABC") ) {
			System.out.println(book);
		}
		System.out.println("              Listing All books between 500 and 600          ");
		for(Book book:service.getBooksInPriceRange(500, 600) ) {
			System.out.println(book);
		}
		System.out.println("                 Listing book with id 102                 ");
		System.out.println("Boo with ID 102:"+service.getBookById(102));
	}
}
