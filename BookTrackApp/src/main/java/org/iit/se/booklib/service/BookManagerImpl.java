package org.iit.se.booklib.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.iit.se.booklib.model.Book;
import org.springframework.stereotype.Service;

@Service
public class BookManagerImpl implements BookManager {

	private List<Book> books = new ArrayList<Book>();
	private Map<String, List<Book>> userToBookMapping = new HashMap<String, List<Book>>();

	public List<Book> getBookByUserId(String userId) {
		List<Book> bookList = new ArrayList<Book>();
		if (StringUtils.isNotEmpty(userId)) {
			bookList.addAll(userToBookMapping.get(userId));
		}
		return bookList;
	}

	public List<Book> getAllBooks() {
		return this.books;
	}

	public List<Book> getBookByName(String bookName) {
		List<Book> bookList = new ArrayList<Book>();
		if (StringUtils.isNotEmpty(bookName)) {
			for (Book preBook : books) {
				if (preBook.getBookName().equals(bookName)) {
					bookList.add(preBook);
				}
			}
		}
		return bookList;
	}

	public void addBook(Book book) {
		if (book != null) {
			if (StringUtils.isNotEmpty(book.getBookName())) {
				books.add(book);
			} else {
				System.out.println("Unable to add book");
			}
		} else {
			System.out.println("Unable to add book");
		}
	}

}
