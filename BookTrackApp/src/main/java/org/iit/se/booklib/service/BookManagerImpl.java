package org.iit.se.booklib.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.iit.se.booklib.dao.BookDao;
import org.iit.se.booklib.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookManagerImpl implements BookManager {

	@Autowired
	BookDao bookDao;
	
	private Map<String, List<Book>> userToBookMapping = new HashMap<String, List<Book>>();

	public List<Book> getBookByUserId(String userId) {
		List<Book> bookList = new ArrayList<Book>();
		if (StringUtils.isNotEmpty(userId)) {
			bookList.addAll(userToBookMapping.get(userId));
		}
		return bookList;
	}

	public List<Book> getAllBooks() {
		return bookDao.getBooks();
	}

	public List<Book> getBookByName(String bookName) {
		List<Book> bookList = bookDao.getBookByName(bookName);
		return bookList;
	}

	public void addBook(Book book) {
		if (book != null) {
			if (StringUtils.isNotEmpty(book.getBookName())) {
				bookDao.addBook(book);
			} else {
				System.out.println("Unable to add book");
			}
		} else {
			System.out.println("Unable to add book");
		}
	}

}
