package com.rest.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.api.repository.Book;
import com.rest.api.repository.BookRepo;

@Service
public class BookService {
	
	@Autowired
	BookRepo bookRepo;
	
	public List<Book> bookList() {
		return bookRepo.findAll();
	}
	
	public Book loadBook(int id) {
		if(bookRepo.findById(id).isEmpty())
		   return new Book(null,"","",0,0);
		return bookRepo.findById(id).get();
	}
	
	public Book saveBook(Book book) {
		System.out.println(book + " saved successfully in DB.");
		return bookRepo.save(book);
	}

}
