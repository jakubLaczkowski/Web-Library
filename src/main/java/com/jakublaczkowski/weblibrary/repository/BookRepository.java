package com.jakublaczkowski.weblibrary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jakublaczkowski.weblibrary.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	Book findBookByIsbn(String isbn);
	List<Book> findAllByAuthor(String author);
}
