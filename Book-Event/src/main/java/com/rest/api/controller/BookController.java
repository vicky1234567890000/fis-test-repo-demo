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
import com.rest.api.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/book")
	public ResponseEntity<List<Book>> bookList() {
		return ResponseEntity.ok().body(bookService.bookList());
	}
	@GetMapping("/book/{id}")
	public ResponseEntity<Book> loadBook(@PathVariable(value="id") Integer id) {
		
		if(bookService.loadBook(id).getBookId()==null)
			return ResponseEntity.ok().body(new Book(null,"","",0,0));
		return ResponseEntity.ok().body(bookService.loadBook(id));
	}
	@PostMapping("/book")
	public ResponseEntity<HttpStatus> saveBook(@RequestBody Book book) {
		bookService.saveBook(book);
		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}

}
