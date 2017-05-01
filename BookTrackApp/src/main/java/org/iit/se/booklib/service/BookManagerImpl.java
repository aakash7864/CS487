package org.iit.se.booklib.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.iit.se.booklib.dao.BookDao;
import org.iit.se.booklib.dao.CourseDao;
import org.iit.se.booklib.model.Book;
import org.iit.se.booklib.model.Courses;
import org.iit.se.booklib.model.SudentBookRequest;
import org.iit.se.booklib.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableSet;

@Service
public class BookManagerImpl implements BookManager {

	@Autowired
	BookDao bookDao;

	@Autowired
	CourseDao courseDao;

	@Autowired
	UserManager userManager;

	@Autowired
	GoogleBookReader googleBookReader;

	private Map<String, List<Book>> userToBookMapping = new HashMap<String, List<Book>>();

	@Override
	public List<Book> getBookByUserId(String userId) {
		List<Book> bookList = new ArrayList<Book>();
		if (StringUtils.isNotEmpty(userId)) {
			bookList.addAll(userToBookMapping.get(userId));
		}
		return bookList;
	}

	@Override
	public List<Book> getAllBooks() {
		return bookDao.getBooks();
	}

	@Override
	public List<Book> getBookByName(String bookName) {
		List<Book> bookList = new ArrayList<>();
		if (StringUtils.isNotEmpty(bookName)) {
			bookList.addAll(bookDao.getBookByName(bookName));
			bookList.addAll(googleBookReader.getBooksFromGoogleAPI(bookName));
		}
		return bookList;
	}

	@Override
	public Book getBookById(String bookNumber) {
		Book book = new Book();
		if (StringUtils.isNotEmpty(bookNumber)) {
			book = bookDao.getBookById(bookNumber);
		}
		return book;
	}

	@Override
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

	@Override
	public void updateBook(Book book) {
		if (book != null) {
			if (StringUtils.isNotEmpty(book.getBookNumber())) {
				bookDao.updateBook(book);
			} else {
				System.out.println("Unable to add book");
			}
		} else {
			System.out.println("Unable to add book");
		}
	}

	@Override
	public void deleteBook(String bookId) {

		if (StringUtils.isNotEmpty(bookId)) {
			bookDao.deleteBook(bookId);

		} else {
			System.out.println("Unable to add book");
		}
	}

	@Override
	public List<Courses> getAllbooksForStudent(String StudentId) {
		List<Courses> courses = new ArrayList<>();
		if (StringUtils.isNotEmpty(StudentId)) {
			User user = userManager.getUserByName(StudentId);

			Set<String> courseName = ImmutableSet
					.copyOf(Splitter.on(',').trimResults().omitEmptyStrings().split(user.getCourseId()));

			Map<String, Courses> map = new HashMap<>();
			for (Courses cor : courseDao.getAll()) {
				map.put(cor.getCourseId(), cor);
			}

			for (String studCor : courseName) {
				if (map.containsKey(studCor)) {
					Courses matched = map.get(studCor);
					matched.setBooks(bookDao.getBookByCourseName(studCor));
					List<Book> books = bookDao.getBookByCourseName(studCor);
					for (Book book : books) {
						if (book.getRequested().equals("0")) {
							courses.add(matched);
						}
					}
				}
			}
		}
		return courses;
	}

	@Override
	public List<SudentBookRequest> getRequestedBook(String StudentId) {
		List<SudentBookRequest> requestedBook = new ArrayList<>();
		List<SudentBookRequest> books = bookDao.getStudentRequestedBook(StudentId);
		if (CollectionUtils.isNotEmpty(books)) {
			for (SudentBookRequest sudentBookRequest : books) {
				if (sudentBookRequest.isRequested().equals("1")) {
					Book book = bookDao.getBookById(sudentBookRequest.getBookId());
					if (book != null) {
						sudentBookRequest.setBookName(book.getBookName());
						sudentBookRequest.setCourse(book.getCourseNumber());
					}
					requestedBook.add(sudentBookRequest);
				}
			}
		}
		return requestedBook;
	}

	@Override
	public List<SudentBookRequest> getRequestedBookForTeacher(String teacherId) {
		List<SudentBookRequest> requestedBook = new ArrayList<>();
		User teacher = userManager.getUserByName(teacherId);

		List<SudentBookRequest> books = bookDao.getAllRequestedBook();
		if (CollectionUtils.isNotEmpty(books)) {
			for (SudentBookRequest sudentBookRequest : books) {
				if (sudentBookRequest.isRequested().equals("1")) {
					Book book = bookDao.getBookById(sudentBookRequest.getBookId());
					if (book != null && book.getCourseNumber() != null
							&& teacher.getCourseId().contains(book.getCourseNumber())) {
						sudentBookRequest.setBookName(book.getBookName());
						sudentBookRequest.setCourse(book.getCourseNumber());
					}
					requestedBook.add(sudentBookRequest);
				}
			}
		}

		return requestedBook;
	}

	@Override
	public List<SudentBookRequest> getAllocatedBook(String StudentId) {
		List<SudentBookRequest> requestedBook = new ArrayList<>();
		List<SudentBookRequest> books = bookDao.getStudentRequestedBook(StudentId);
		if (CollectionUtils.isNotEmpty(books)) {
			for (SudentBookRequest sudentBookRequest : books) {
				if (sudentBookRequest.isRequested().equals("0")) {
					Book book = bookDao.getBookById(sudentBookRequest.getBookId());
					if (book != null) {
						sudentBookRequest.setBookName(book.getBookName());
						sudentBookRequest.setCourse(book.getCourseNumber());
						int fine;
						if ((new Date().toString()).compareTo(sudentBookRequest.getDueDate()) < 0) {
							fine = 0;
						} else {
							fine = 10;
						}
						sudentBookRequest.setFine(fine);
					}
					requestedBook.add(sudentBookRequest);
				}
			}
		}
		return requestedBook;
	}

	@Override
	public void requestBook(String userid, String bookId) {
		bookDao.addUSerBook(userid, bookId);
	}

	@Override
	public void checkoutBook(String userid, String bookId) {
		bookDao.checkoutStudentBook(userid, bookId);
	}
}
