package com.rest.api.SubscriptionEvents.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import com.rest.api.SubscriptionEvents.repository.Book;
import com.rest.api.SubscriptionEvents.repository.Subscription;
import com.rest.api.SubscriptionEvents.service.SubscriptionEventService;

import reactor.core.publisher.Mono;

@RestController
public class SubscriptionEventController {

	@Autowired
	SubscriptionEventService service;

	@GetMapping("/subscriptions")
	public ResponseEntity<List<Subscription>> getAllSubscriptions() {
		List<Subscription> allSubscribers = service.getAllSubscribers();
		return ResponseEntity.ok().body(allSubscribers);
	}

	@PostMapping("/subscriptions")
	public ResponseEntity<String> postSubscription(@RequestBody Subscription subscription) {

		Book book = service.fetchBook(subscription.getBookId());

		if (book.getBookId() != null && book.getAvailableCopies() > 0) {
			service.saveSubscriber(subscription);
			return ResponseEntity.status(HttpStatus.CREATED).body("Successful creation of a subscription record");
		}
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
				.body("No book found with bookId : " + subscription.getBookId());
	}

}
