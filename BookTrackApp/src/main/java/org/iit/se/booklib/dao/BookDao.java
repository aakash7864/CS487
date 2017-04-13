package org.iit.se.booklib.dao;

import java.util.List;

import org.iit.se.booklib.model.Book;

public interface  BookDao {

	void addBook(Book book);
	
	List<Book> getBookByName(String bookName);
	
	List<Book> getBookByAuthor(String authorName);
	
	List<Book> getBooks();

}
