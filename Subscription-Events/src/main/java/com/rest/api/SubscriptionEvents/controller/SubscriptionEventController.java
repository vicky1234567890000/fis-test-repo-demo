package com.rest.api.SubscriptionEvents.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rest.api.SubscriptionEvents.repository.Book;

@RestController
public class SubscriptionEventController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/subscription")
	public Book getBookId() {
		
		Book book = restTemplate.getForObject("http://localhost:8080/book/1111",
				Book.class);
		System.out.println("fetched book is " + book);
		return book;
	}

}
