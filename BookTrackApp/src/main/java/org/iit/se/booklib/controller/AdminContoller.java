package org.iit.se.booklib.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.iit.se.booklib.dao.CourseDao;
import org.iit.se.booklib.model.Book;
import org.iit.se.booklib.model.Courses;
import org.iit.se.booklib.model.User;
import org.iit.se.booklib.service.BookManager;
import org.iit.se.booklib.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.common.collect.ImmutableList;

@Controller
@RequestMapping("/admin")
public class AdminContoller {

	@Autowired
	UserManager userManager;

	@Autowired
	BookManager bookManager;

	@Autowired
	CourseDao courseDao;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String adminPage(Model model, HttpSession session) {
		if (session.getAttribute("userId") != null && session.getAttribute("role") != null
				&& session.getAttribute("role").equals("Admin")) {
			User user = userManager.getUserByName((String) session.getAttribute("userId"));
			model.addAttribute("user", user);
			if (!model.containsAttribute("books")) {
				model.addAttribute("books", bookManager.getAllBooks());
			}
			return "admin";
		} else {
			return "login";
		}

	}

	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
	public String addBook(@ModelAttribute("bookForm") Book book, Model model, HttpSession session) {
		if (session.getAttribute("role").equals("Admin") && book != null) {
			bookManager.addBook(book);
			model.addAttribute("books", bookManager.getAllBooks());
		}
		return "redirect:/admin";
	}

	@RequestMapping(value = "/addBook", method = RequestMethod.GET)
	public String registration(Model model, HttpSession session) {
		model.addAttribute("bookForm", new Book());
		return "addBook";
	}

	@RequestMapping(value = "/updateBook", method = RequestMethod.GET)
	public String updateBookPage(@RequestParam String bookNumber, Model model, HttpSession session) {
		model.addAttribute("bookForm", bookManager.getBookById(bookNumber));
		return "updateBook";
	}

	@RequestMapping(value = "/deleteBook", method = RequestMethod.POST)
	public String deleteBook(@RequestParam String bookNumber, Model model, HttpSession session) {
		if (session.getAttribute("role").equals("Admin") && StringUtils.isNotEmpty(bookNumber)) {
			bookManager.deleteBook(bookNumber);
		}
		return "redirect:/admin";
	}

	@RequestMapping(value = "/updateBook", method = RequestMethod.POST)
	public String updateBook(@ModelAttribute("bookForm") Book book, Model model, HttpSession session) {
		if (session.getAttribute("role").equals("Admin") && book != null) {
			bookManager.updateBook(book);
			model.addAttribute("books", bookManager.getAllBooks());
		}
		return "redirect:/admin";
	}

	@RequestMapping(value = "/searchBook", method = RequestMethod.POST)
	public String addBook(@RequestParam String bookName, Model model) {
		model.addAttribute("books", bookManager.getBookByName(bookName));
		return "searchBook";
	}

	@RequestMapping(value = "/account", method = RequestMethod.GET)
	public String viewAccount(Model model, HttpSession session) {
		if (session.getAttribute("userId") != null && session.getAttribute("role") != null
				&& session.getAttribute("role").equals("Admin")) {
			User user = userManager.getUserByName((String) session.getAttribute("userId"));
			model.addAttribute("user", user);

			return "adminAccount";
		} else {
			return "redirect:/login";
		}
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String viewUsers(Model model, HttpSession session) {
		if (session.getAttribute("userId") != null && session.getAttribute("role") != null
				&& session.getAttribute("role").equals("Admin")) {
			List<User> users = userManager.getUsers();
			model.addAttribute("users", users);
			return "users";
		} else {
			return "redirect:/login";
		}
	}

	@RequestMapping(value = "/addStudent", method = RequestMethod.GET)
	public String addUserPage(Model model, HttpSession session) {
		if (session.getAttribute("userId") != null && session.getAttribute("role") != null
				&& session.getAttribute("role").equals("Admin")) {
			model.addAttribute("userForm", new User());
			model.addAttribute("userRole", ImmutableList.of("Student"));
			ArrayList<String> courcesIds = new ArrayList<>();
			for (Courses Courses : courseDao.getAll()) {
				courcesIds.add(Courses.getCourseId());
			}
			model.addAttribute("courseIds", courcesIds);
			return "addStudent";
		} else {
			return "redirect:/login";
		}
	}

	@RequestMapping(value = "/addTeacher", method = RequestMethod.GET)
	public String addTeacherPage(Model model, HttpSession session) {
		if (session.getAttribute("userId") != null && session.getAttribute("role") != null
				&& session.getAttribute("role").equals("Admin")) {
			model.addAttribute("userForm", new User());
			model.addAttribute("userRole", ImmutableList.of("Teacher"));
			ArrayList<String> courcesIds = new ArrayList<>();
			for (Courses Courses : courseDao.getAll()) {
				courcesIds.add(Courses.getCourseId());
			}
			model.addAttribute("courseIds", courcesIds);
			return "addTeacher";
		} else {
			return "redirect:/login";
		}
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model,
			HttpSession session) {

		if (userForm.getRole().equals("Student")) {
			Random rand = new Random();
			int n = rand.nextInt(50000) + 10000;
			userForm.setStudentId(String.valueOf(n));
		} else if (userForm.getRole().equals("Teacher")) {
			Random rand = new Random();
			int n = rand.nextInt(5000) + 1000;
			userForm.setProfId(String.valueOf(n));
		}
		userManager.addUser(userForm);

		return "redirect:/admin/users";
	}
}
