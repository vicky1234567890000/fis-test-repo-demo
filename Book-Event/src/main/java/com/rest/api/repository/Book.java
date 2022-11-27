package com.rest.api.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Books")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private Integer bookId;
	@Column(name = "book_name")
	private String bookName;
	@Column(name = "author")
    private String author;
	@Column(name = "avaiable_copies")
    private Integer availableCopies;
	@Column(name = "total_copies")
    private Integer totalCopies;
    
    public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getAvailableCopies() {
		return availableCopies;
	}
	public void setAvailableCopies(Integer availableCopies) {
		this.availableCopies = availableCopies;
	}
	public Integer getTotalCopies() {
		return totalCopies;
	}
	public void setTotalCopies(Integer totalCopies) {
		this.totalCopies = totalCopies;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", author=" + author + ", availableCopies="
				+ availableCopies + ", totalCopies=" + totalCopies + "]";
	}
	
	
}
