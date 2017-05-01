package org.iit.se.booklib.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.iit.se.booklib.model.Book;
import org.iit.se.booklib.model.SudentBookRequest;
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
				"INSERT INTO BOOK(book_number, book_name, book_author, book_price, book_publication, created_date, requested) VALUES (?,?,?,?,?,?,?)",
				book.getBookNumber(), book.getBookName(), book.getBookAuthor(), book.getBookPrice(),
				book.getBookPublication(), new Date(), false);
	}

	@Override
	public void addBook(Book book,int avilableQty,int allocAquantity) {
		jdbcTemplate.update(
				"INSERT INTO BOOK(book_number, book_name, book_author, book_price, book_publication, created_date, requested, ava_quantity, alloc_quantity) VALUES (?,?,?,?,?,?,?,?,?)",
				book.getBookNumber(), book.getBookName(), book.getBookAuthor(), book.getBookPrice(),
				book.getBookPublication(), new Date(), false,avilableQty,allocAquantity);
	}
	
	@Override
	public void addUSerBook(String studentId, String bookid) {
		jdbcTemplate.update("INSERT INTO USER_BOOK(studentId, bookId, requestedDate, requested) VALUES (?,?,?,?)",
				studentId, bookid, new Date().toString(), true);
		jdbcTemplate.update("UPDATE BOOK SET requested = ? WHERE book_number = ?",
				true, bookid);
	}

	@Override
	public void checkoutStudentBook(String studentId, String bookId) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 15);
		jdbcTemplate.update(
				"UPDATE USER_BOOK SET allocationDate = ?, returnDate= ?, requested = ? WHERE studentId = ? AND bookId = ?",
				new Date().toString(), cal.getTime().toString(), false, studentId, bookId);
	}

	@Override
	public List<SudentBookRequest> getStudentRequestedBook(String studentId) {

		String sql = "SELECT * FROM USER_BOOK WHERE studentId = '" + studentId + "'";

		List<SudentBookRequest> books = new ArrayList<SudentBookRequest>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		if (CollectionUtils.isNotEmpty(rows)) {
			for (Map row : rows) {
				SudentBookRequest book = new SudentBookRequest();
				book.setBookId((String) (row.get("bookId")));
				book.setRequestedDate((String) (row.get("requestedDate")));
				book.setAllocationDate((String) (row.get("allocationDate")));
				book.setDueDate((String) (row.get("returnDate")));
				book.setRequested((String) (row.get("requested")));
				books.add(book);
			}
		}
		return books;

	}

	@Override
	public List<SudentBookRequest> getAllRequestedBook() {

		String sql = "SELECT * FROM USER_BOOK";

		List<SudentBookRequest> books = new ArrayList<SudentBookRequest>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		if (CollectionUtils.isNotEmpty(rows)) {
			for (Map row : rows) {
				SudentBookRequest book = new SudentBookRequest();
				book.setStudentId((String) (row.get("studentId")));
				book.setBookId((String) (row.get("bookId")));
				book.setRequestedDate((String) (row.get("requestedDate")));
				book.setAllocationDate((String) (row.get("allocationDate")));
				book.setDueDate((String) (row.get("returnDate")));
				book.setRequested((String) (row.get("requested")));
				books.add(book);
			}
		}
		return books;

	}

	@Override
	public void updateBook(Book book) {
		jdbcTemplate.update(
				"UPDATE BOOK SET book_name = ?, book_author= ?, book_price = ?, book_publication = ? WHERE book_number = ?",
				book.getBookName(), book.getBookAuthor(), book.getBookPrice(), book.getBookPublication(),
				book.getBookNumber());
	}

	@Override
	public List<Book> getBookByName(String bookName) {

		String sql = "SELECT * FROM BOOK WHERE book_name LIKE '%" + bookName + "%'";

		List<Book> books = new ArrayList<Book>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		if (CollectionUtils.isNotEmpty(rows)) {
			for (Map row : rows) {
				Book book = new Book();
				book.setBookNumber((String) (row.get("book_number")));
				book.setBookName((String) (row.get("book_name")));
				book.setBookAuthor((String) (row.get("book_author")));
				book.setBookPrice(new BigDecimal((String) row.get("book_price")));
				book.setBookPublication((String) (row.get("book_publication")));
				book.setRequested((String) (row.get("requested")));
				books.add(book);
			}
		}
		return books;

	}

	@Override
	public Book getBookById(String bookId) {

		String sql = "SELECT * FROM BOOK WHERE book_number = '" + bookId + "'";

		List<Book> books = new ArrayList<Book>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		if (CollectionUtils.isNotEmpty(rows)) {
			for (Map row : rows) {
				Book book = new Book();
				book.setBookNumber((String) (row.get("book_number")));
				book.setBookName((String) (row.get("book_name")));
				book.setBookAuthor((String) (row.get("book_author")));
				book.setBookPrice(new BigDecimal((String) row.get("book_price")));
				book.setBookPublication((String) (row.get("book_publication")));
				book.setCourseNumber((String) (row.get("courseId")));
				book.setRequested((String) (row.get("requested")));
				books.add(book);
			}
		}
		return books.get(0);

	}

	@Override
	public List<Book> getBookByCourseName(String courseName) {

		String sql = "SELECT * FROM BOOK WHERE courseId = '" + courseName + "'";

		List<Book> books = new ArrayList<Book>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		if (CollectionUtils.isNotEmpty(rows)) {
			for (Map row : rows) {
				Book book = new Book();
				book.setBookNumber((String) (row.get("book_number")));
				book.setBookName((String) (row.get("book_name")));
				book.setBookAuthor((String) (row.get("book_author")));
				book.setBookPrice(new BigDecimal((String) row.get("book_price")));
				book.setBookPublication((String) (row.get("book_publication")));
				book.setRequested((String) (row.get("requested")));
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
				book.setBookPrice(new BigDecimal((String) row.get("book_price")));
				book.setBookPublication((String) (row.get("book_publication")));
				book.setRequested((String) (row.get("requested")));
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
				book.setAvilableQuanity((int) (row.get("ava_quantity")));
				book.setRequested((String) (row.get("requested")));
				books.add(book);
			}
		}
		return books;
	}

	@Override
	public void deleteBook(String bookId) {
		String sql = "DELETE FROM BOOK where book_number ='" + bookId + "'";
		jdbcTemplate.execute(sql);
	}

}
