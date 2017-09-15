package com.jakublaczkowski.weblibrary.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CUSTOMER_ID")
	private Long customerId;

	@Column(name = "DATE_JOINED")
	private Date dateJoined;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "PESEL")
	private String pesel;

	@Column(name = "EMAIL")
	private String email;

	@OneToOne(mappedBy = "customer")
	private Book book;

	public Customer(Date dateJoined, String firstName, String lastName, String pesel, String email, Book book) {
		this.dateJoined = dateJoined;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pesel = pesel;
		this.email = email;
		this.book = book;
	}

	public Date getDateJoined() {
		return dateJoined;
	}

	public String getFirstName() {
		return firstName;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public void setDateJoined(Date dateJoined) {
		this.dateJoined = dateJoined;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
