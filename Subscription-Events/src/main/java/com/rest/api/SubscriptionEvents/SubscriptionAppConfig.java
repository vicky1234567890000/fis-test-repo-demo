package com.rest.api.SubscriptionEvents;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class SubscriptionAppConfig {
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public WebClient webClient() 
	{
		return WebClient.builder()
				.baseUrl("http://localhost:8080")
				.build();
	}

}
