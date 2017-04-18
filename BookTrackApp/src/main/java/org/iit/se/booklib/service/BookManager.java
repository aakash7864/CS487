package org.iit.se.booklib.service;

import java.util.List;

import org.iit.se.booklib.model.Book;
import org.iit.se.booklib.model.Courses;
import org.iit.se.booklib.model.SudentBookRequest;

public interface BookManager {

	List<Book> getBookByUserId(String userId);

	void addBook(Book book);

	List<Book> getAllBooks();

	List<Book> getBookByName(String bookName);

	Book getBookById(String bookNumber);

	void updateBook(Book book);

	void deleteBook(String bookId);

	List<Courses> getAllbooksForStudent(String StudentId);

	void requestBook(String userid, String bookId);

	List<SudentBookRequest> getAllocatedBook(String StudentId);

	List<SudentBookRequest> getRequestedBook(String StudentId);

	void checkoutBook(String userid, String bookId);

	List<SudentBookRequest> getRequestedBookForTeacher(String teacherId);
}
