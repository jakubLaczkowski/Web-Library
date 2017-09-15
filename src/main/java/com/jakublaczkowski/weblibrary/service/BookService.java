package com.jakublaczkowski.weblibrary.service;

import java.util.List;

import com.jakublaczkowski.weblibrary.exception.BookAlreadyLentException;
import com.jakublaczkowski.weblibrary.exception.BookDoesNotExistException;
import com.jakublaczkowski.weblibrary.exception.CustomerDoesNotExistException;
import com.jakublaczkowski.weblibrary.model.Book;

public interface BookService {
	
	void addBook(Book book);//
	void removeBook(Long bookId);//
	void updateBook(Long bookId, Book book);//
	Book getBook(Long bookId); //
	Book getBookByIsbn(String isbn); //
	List<Book> getAllBooks(); //
	List<Book> getBooksByAuthor(String author);
	void lendBook(Long bookId, Long customerId) throws CustomerDoesNotExistException, 
														BookDoesNotExistException, BookAlreadyLentException;
	void returnBook(Long bookId, Long customerId) throws CustomerDoesNotExistException, BookDoesNotExistException;
	
	
}
