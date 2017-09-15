package com.jakublaczkowski.weblibrary.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BOOK_ID")
	private Long bookId;

	@Column(name = "AUTHOR")
	private String author;

	@Column(name = "ISBN")
	private String isbn;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "DATE_LENT")
	private Date dateLent;

	@OneToOne
	@JoinColumn(name = "CUSTOMER_ID")
	private Customer customer;

	@Column(name = "RENTAL_DATE")
	private LocalDate rentalDate;

	@Column(name = "RETURN_DATE")
	private LocalDate returnDate;

	@Column(name = "STATUS")
	private Status status = Status.AVAILABLE;

	public Book(String author, String isbn, String title, Date dateLent, Customer customer, LocalDate rentalDate,
			LocalDate returnDate) {
		this.author = author;
		this.isbn = isbn;
		this.title = title;
		this.dateLent = dateLent;
		this.customer = customer;
		this.rentalDate = rentalDate;
		this.returnDate = returnDate;
	}

	public String getAuthor() {
		return author;
	}

	public Long getBookId() {
		return bookId;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setBookId(Long id) {
		this.bookId = id;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDateLent() {
		return dateLent;
	}

	public void setDateLent(Date dateLent) {
		this.dateLent = dateLent;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public LocalDate getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(LocalDate rentalDate) {
		this.rentalDate = rentalDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public enum Status {
		AVAILABLE, NON_AVAILABLE
	}
}
