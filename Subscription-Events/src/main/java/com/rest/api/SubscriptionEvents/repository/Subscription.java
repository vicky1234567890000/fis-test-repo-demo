package com.rest.api.SubscriptionEvents.repository;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Subscriptions")
public class Subscription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subscriber_id")
	private Integer subscriberId;
	
	@Column(name = "subscriber_name")
	private String subscriberName;
	
	@Column(name = "date_subscribed")
	private Date dateSubscribed;
	
	@Column(name = "date_returned")
	private Date dateReturned;
	
	@Column(name = "book_id")
	private Integer bookId;
	
	public Subscription() {
		super();
	}

	public Integer getSubscriberId() {
		return subscriberId;
	}

	public void setSubscriberId(Integer subscriberId) {
		this.subscriberId = subscriberId;
	}

	public String getSubscriberName() {
		return subscriberName;
	}

	public void setSubscriberName(String subscriberName) {
		this.subscriberName = subscriberName;
	}

	public Date getDateSubscribed() {
		return dateSubscribed;
	}

	public void setDateSubscribed(Date dateSubscribed) {
		this.dateSubscribed = dateSubscribed;
	}

	public Date getDateReturned() {
		return dateReturned;
	}

	public void setDateReturned(Date dateReturned) {
		this.dateReturned = dateReturned;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	@Override
	public String toString() {
		return "Subscription [subscriberId=" + subscriberId + ", subscriberName=" + subscriberName + ", dateSubscribed="
				+ dateSubscribed + ", dateReturned=" + dateReturned + ", bookId=" + bookId + "]";
	}
	
	
	
}
