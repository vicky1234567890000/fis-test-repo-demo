package com.rest.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.repository.Book;
import com.rest.api.repository.BookRepo;

@RestController
public class BookController {
	
	@Autowired
	private BookRepo bookRepo;
	
	@GetMapping("/book")
	public ResponseEntity<List<Book>> bookList() {
		return ResponseEntity.ok().body(bookRepo.findAll());
	}
	@GetMapping("/book/{id}")
	public ResponseEntity<Optional<Book>> loadBook(@PathVariable(value="id") Integer id) {
		
		return ResponseEntity.ok().body(bookRepo.findById(id));
	}
	@PostMapping("/book")
	public ResponseEntity<HttpStatus> saveBook(@RequestBody Book book) {
		bookRepo.save(book);
		System.out.println(book + " saved successfully in DB.");
		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}

}
