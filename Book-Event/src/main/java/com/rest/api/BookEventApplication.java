package com.rest.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;

import com.rest.api.controller.BookController;
import com.rest.api.repository.Book;

@SpringBootApplication
public class BookEventApplication implements CommandLineRunner {
	
	@Autowired
	private BookController bookController;

	public static void main(String[] args) {
		SpringApplication.run(BookEventApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		ResponseEntity<List<Book>> bookListResponse = bookController.bookList();
		System.out.println(bookListResponse.getBody());
		
		ResponseEntity<Optional<Book>> bookResponse = bookController.loadBook(1213);
		if(bookResponse.getBody().isPresent()) System.out.println("the book requested is " + bookResponse.getBody().get());
		else System.out.println("Book does not exist");
		*/
		
	}

}
