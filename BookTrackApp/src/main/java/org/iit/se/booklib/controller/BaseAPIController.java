package org.iit.se.booklib.controller;

import java.util.List;

import org.iit.se.booklib.model.Book;
import org.iit.se.booklib.model.User;
import org.iit.se.booklib.service.BookManager;
import org.iit.se.booklib.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cs487/book/api")
public class BaseAPIController {

	@Autowired
	UserManager userManager;

	@Autowired
	BookManager bookManager;

	@RequestMapping(value = "/books", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Book> getBooks() {
		return bookManager.getAllBooks();
	}

	@RequestMapping(value = "/getUsers/{userName}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody User getCheckpointsbyName(@PathVariable String userName) {
		return userManager.getUserByName(userName);
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<User> getConfiguredOrderEvents() {
		return userManager.getUsers();
	}

	@RequestMapping(value = "/book/{bookName}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Book> getUserByName(@PathVariable String bookName) {
		return bookManager.getBookByName(bookName);
	}

	@RequestMapping(value = "/user/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public List<User> addUser(@RequestBody User user) {
		if (user != null) {
			userManager.addUser(user);
		}

		return userManager.getUsers();
	}

	@RequestMapping(value = "/book/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public List<Book> addBook(@RequestBody Book book) {
		if (book != null) {
			bookManager.addBook(book);
		}

		return bookManager.getAllBooks();
	}
}
