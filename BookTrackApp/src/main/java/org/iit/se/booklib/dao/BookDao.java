package org.iit.se.booklib.dao;

import java.util.List;

import org.iit.se.booklib.model.Book;
import org.iit.se.booklib.model.SudentBookRequest;

public interface  BookDao {

	void addBook(Book book);
	
	List<Book> getBookByName(String bookName);
	
	List<Book> getBookByAuthor(String authorName);
	
	List<Book> getBooks();

	Book getBookById(String bookId);

	void updateBook(Book book);

	void deleteBook(String bookId);

	List<Book> getBookByCourseName(String courseName);

	void addUSerBook(String studentId, String bookid);

	List<SudentBookRequest> getStudentRequestedBook(String studentId);

	List<SudentBookRequest> getAllRequestedBook();

	void checkoutStudentBook(String studentId, String bookId);

	void addBook(Book book, int avilableQty, int allocAquantity);

}
