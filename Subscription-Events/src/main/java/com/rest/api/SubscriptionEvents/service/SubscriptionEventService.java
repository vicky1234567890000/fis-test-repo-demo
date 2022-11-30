package com.rest.api.SubscriptionEvents.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.rest.api.SubscriptionEvents.repository.Book;
import com.rest.api.SubscriptionEvents.repository.Subscription;
import com.rest.api.SubscriptionEvents.repository.SubscriptionRepo;

@Service
public class SubscriptionEventService {

	@Autowired
	WebClient webClient;
	
	@Autowired
	SubscriptionRepo subscriptionRepo;

	public Book fetchBook(int id) {

		return webClient
				.get()
				.uri("/book/" + id)
				.retrieve()
				.bodyToMono(Book.class)
				.block();
	}
	
	public Subscription saveSubscriber(Subscription subscription) {
		return subscriptionRepo.save(subscription);
	}

	public List<Subscription> getAllSubscribers() {
		return subscriptionRepo.findAll();
	}
}
