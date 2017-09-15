package com.jakublaczkowski.weblibrary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jakublaczkowski.weblibrary.model.Book;
import com.jakublaczkowski.weblibrary.service.BookService;

@Controller
public class BookController {
	
	private BookService bookService;
	
	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping(value = "books")
	public List<Book> listBooks(){
		return bookService.getAllBooks();	
	}
	
	@GetMapping(value = "books/{id}")
	public Book getBook(@PathVariable("id") Long bookId){
		return bookService.getBook(bookId);
	}
	
	@GetMapping(value = "books/isbn/{isbn}")
	public Book getBookByIsbn(@PathVariable("isbn") String isbn){
		return bookService.getBookByIsbn(isbn);
	}
	
	@PostMapping(value = "books")
	public void addBook(@RequestBody Book book){
		bookService.addBook(book);
	}
	
	@PutMapping(value = "books/{id}")
	public void updateBook(@PathVariable("id") Long bookId, @RequestBody Book book){
		bookService.updateBook(bookId, book);
	}
	
	@DeleteMapping(value = "books/{id}")
	public void removeBook(@PathVariable("id") Long bookId){
		bookService.removeBook(bookId);
	}
	
	@GetMapping(value = "books/authors/{author}")
	public List<Book> getBooksByAuthor(@PathVariable("author") String author){
		return bookService.getBooksByAuthor(author);
	}
}
