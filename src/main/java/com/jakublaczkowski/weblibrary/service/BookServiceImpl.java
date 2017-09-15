package com.jakublaczkowski.weblibrary.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jakublaczkowski.weblibrary.exception.BookAlreadyLentException;
import com.jakublaczkowski.weblibrary.exception.BookDoesNotExistException;
import com.jakublaczkowski.weblibrary.exception.CustomerDoesNotExistException;
import com.jakublaczkowski.weblibrary.model.Book;
import com.jakublaczkowski.weblibrary.model.Book.Status;
import com.jakublaczkowski.weblibrary.model.Customer;
import com.jakublaczkowski.weblibrary.repository.BookRepository;
import com.jakublaczkowski.weblibrary.repository.CustomerRepository;

@Service("bookService")
public class BookServiceImpl implements BookService {

	private CustomerRepository customerRepository;
	private BookRepository bookRepository;

	@Autowired
	public BookServiceImpl(CustomerRepository customerRepository, BookRepository bookRepository) {
		this.customerRepository = customerRepository;
		this.bookRepository = bookRepository;
	}

	public void addBook(Book book) {
		bookRepository.saveAndFlush(book);
	}

	public void removeBook(Long bookId) {
		Book book = bookRepository.getOne(bookId);
		bookRepository.delete(book);
	}

	public void updateBook(Long bookId, Book book) {
		Book existingBook = bookRepository.findOne(bookId);
		BeanUtils.copyProperties(book, existingBook);
		bookRepository.saveAndFlush(existingBook);
	}

	public Book getBook(Long bookId) {
		return bookRepository.findOne(bookId);
	}

	public Book getBookByIsbn(String isbn) {
		return bookRepository.findBookByIsbn(isbn);
	}

	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	public List<Book> getBooksByAuthor(String author) {
		return bookRepository.findAllByAuthor(author);
	}

	public void lendBook(Long bookId, Long customerId) 
					throws CustomerDoesNotExistException, BookDoesNotExistException, BookAlreadyLentException {
		LocalDate rentalDate = LocalDate.now();
		Customer existingCustomer = customerRepository.findOne(customerId);
		Book existingBook = bookRepository.findOne(bookId);

		if (existingCustomer == null)
			throw new CustomerDoesNotExistException("No user found.");
		
		if (existingBook == null)
			throw new BookDoesNotExistException("No book found.");
		
		if(existingBook.getStatus() == Status.NON_AVAILABLE)
			throw new BookAlreadyLentException("Book already lent to another customer.");
		
		existingCustomer.setBook(existingBook);
		existingBook.setCustomer(existingCustomer);
		existingBook.setRentalDate(rentalDate);
		existingBook.setReturnDate(rentalDate.plusMonths(2));

		customerRepository.saveAndFlush(existingCustomer);
		bookRepository.saveAndFlush(existingBook);
	}

	public void returnBook(Long bookId, Long customerId) throws CustomerDoesNotExistException, BookDoesNotExistException {
		Customer existingCustomer = customerRepository.findOne(customerId);
		Book existingBook = bookRepository.findOne(bookId);

		if (existingCustomer == null)
			throw new CustomerDoesNotExistException("No user found.");
		
		if (existingBook == null)
			throw new BookDoesNotExistException("No book found.");
		
		existingCustomer.setBook(null);
		existingBook.setCustomer(null);

		customerRepository.saveAndFlush(existingCustomer);
		bookRepository.saveAndFlush(existingBook);
	}

}
