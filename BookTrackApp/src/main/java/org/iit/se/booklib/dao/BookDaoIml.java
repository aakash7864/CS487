package org.iit.se.booklib.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.iit.se.booklib.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoIml implements BookDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void addBook(Book book) {
		jdbcTemplate.update(
				"INSERT INTO BOOK(book_number, book_name, book_author, book_price, book_publication, created_date) VALUES (?,?,?,?,?,?)",
				book.getBookNumber(), book.getBookName(), book.getBookAuthor(), book.getBookPrice(),
				book.getBookPublication(), new Date());
	}

	@Override
	public List<Book> getBookByName(String bookName) {

		String sql = "SELECT * FROM BOOK WHERE book_name = '" + bookName + "'";

		List<Book> books = new ArrayList<Book>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		if (CollectionUtils.isNotEmpty(rows)) {
			for (Map row : rows) {
				Book book = new Book();
				book.setBookNumber((String) (row.get("book_number")));
				book.setBookName((String) (row.get("book_name")));
				book.setBookAuthor((String) (row.get("book_author")));
				book.setBookPrice((BigDecimal) (row.get("book_price")));
				book.setBookPublication((String) (row.get("book_publication")));
				books.add(book);
			}
		}
		return books;

	}

	@Override
	public List<Book> getBookByAuthor(String authorName) {

		String sql = "SELECT * FROM BOOK WHERE book_author = '" + authorName + "'";

		List<Book> books = new ArrayList<Book>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		if (CollectionUtils.isNotEmpty(rows)) {
			for (Map row : rows) {
				Book book = new Book();
				book.setBookNumber((String) (row.get("book_number")));
				book.setBookName((String) (row.get("book_name")));
				book.setBookAuthor((String) (row.get("book_author")));
				book.setBookPrice((BigDecimal) (row.get("book_price")));
				book.setBookPublication((String) (row.get("book_publication")));
				books.add(book);
			}
		}
		return books;

	}

	@Override
	public List<Book> getBooks() {
		String sql = "SELECT * FROM BOOK";

		List<Book> books = new ArrayList<Book>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		if (CollectionUtils.isNotEmpty(rows)) {
			for (Map row : rows) {
				Book book = new Book();
				book.setBookNumber((String) (row.get("book_number")));
				book.setBookName((String) (row.get("book_name")));
				book.setBookAuthor((String) (row.get("book_author")));
				book.setBookPrice(new BigDecimal((String) (row.get("book_price"))));
				book.setBookPublication((String) (row.get("book_publication")));
				books.add(book);
			}
		}
		return books;
	}

}
