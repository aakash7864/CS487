package org.iit.se.booklib.service;

import java.util.List;

import org.iit.se.booklib.model.Book;

public interface BookManager {

	List<Book> getBookByUserId(String userId);

	void addBook(Book book);

	List<Book> getAllBooks();

	List<Book> getBookByName(String bookName);
}
