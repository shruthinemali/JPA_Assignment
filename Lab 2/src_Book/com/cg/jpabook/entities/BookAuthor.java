package com.cg.jpabook.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BookAuthor {
	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
	

		Book AutoBiography = new Book();
		AutoBiography.setIsbn(1);
		AutoBiography.setTitle("ABC");
		AutoBiography.setPrice(450);
		
		Book Philosopy = new Book();
		Philosopy.setIsbn(2);
		Philosopy.setTitle("EFG");
		Philosopy.setPrice(520);
		
		Book Fiction = new Book();
		Fiction.setIsbn(3);
		Fiction.setTitle("HIJ");
		Fiction.setPrice(350);
		
		Author firstAuthor = new Author();
		firstAuthor.setId(1000);
		firstAuthor.addBook(AutoBiography);
		firstAuthor.addBook(Philosopy);
		
		Author secondAuthor = new Author();
		secondAuthor.setId(1001);
		secondAuthor.addBook(Philosopy);		
		secondAuthor.addBook(Fiction);
		
		em.persist(firstAuthor);
		em.persist(secondAuthor);
		
		System.out.println("Added Author along with Author details to database.");

		transaction.commit();
		em.close();
		factory.close();
	}
}
