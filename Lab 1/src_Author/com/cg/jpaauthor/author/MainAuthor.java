package com.cg.jpaauthor.author;

import java.util.Scanner;

import com.cg.jpaauthor.entities.Author;
import com.cg.jpaauthor.service.AuthorService;
import com.cg.jpaauthor.service.AuthorServiceImpl;


public class MainAuthor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AuthorService service = new AuthorServiceImpl();
		int choice=0;
		Scanner sc=new Scanner(System.in);
		do
		{
			System.out.println("1-Add Author");
			System.out.println("2-Update Author");
			System.out.println("3-Remove Author");
			System.out.println("Enter Choice-");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1: 
				System.out.println("Enter firstName:");
				String fname=sc.next();
				System.out.println("Enter middleName:");
				String mname=sc.next();
				System.out.println("Enter lastName:");
				String lname=sc.next();
				System.out.println("Enter phoneNo:");
				long phoneNo=sc.nextLong();
				Author author=new Author();
				author.setFirstName(fname);
				author.setMiddleName(mname);
				author.setLastName(lname);
				author.setPhoneNo(phoneNo);
				service.addAuthor(author);
				
				break;
			
			}
			System.out.println("Do you to continue 1-Yes, 0-No");
			choice= sc.nextInt();
		}while(choice!=0);
	}
}
