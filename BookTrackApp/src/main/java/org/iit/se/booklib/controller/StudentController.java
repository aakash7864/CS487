package org.iit.se.booklib.controller;

import javax.servlet.http.HttpSession;

import org.iit.se.booklib.model.User;
import org.iit.se.booklib.service.BookManager;
import org.iit.se.booklib.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
	@Autowired
	UserManager userManager;
	@Autowired
	BookManager bookManager;

	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String studentPage(Model model, HttpSession session) {
		if (session.getAttribute("userId") != null && session.getAttribute("role") != null
				&& session.getAttribute("role").equals("Student")) {
			User user = userManager.getUserByName((String) session.getAttribute("userId"));
			model.addAttribute("user", user);
			model.addAttribute("studentBook", bookManager.getAllbooksForStudent(user.getUserId()));
			model.addAttribute("requestedBook", bookManager.getRequestedBook(user.getUserId()));
			model.addAttribute("allocatedBook", bookManager.getAllocatedBook(user.getUserId()));
			return "student";
		} else {
			return "redirect:/login";
		}
	}

	@RequestMapping(value = "/student/requestBook", method = RequestMethod.POST)
	public String requestBook(@RequestParam String bookNumber, HttpSession session) {
		if (session.getAttribute("userId") != null && session.getAttribute("role") != null
				&& session.getAttribute("role").equals("Student")) {
			User user = userManager.getUserByName((String) session.getAttribute("userId"));
			bookManager.requestBook(user.getUserId(), bookNumber);
			return "redirect:/student";
		} else {
			return "redirect:/login";
		}
	}
	
	@RequestMapping(value = "/student/account", method = RequestMethod.GET)
	public String studentAccPage(Model model, HttpSession session) {
		if (session.getAttribute("userId") != null && session.getAttribute("role") != null
				&& session.getAttribute("role").equals("Student")) {
			User user = userManager.getUserByName((String) session.getAttribute("userId"));
			model.addAttribute("user", user);
			return "studentAccount";
		} else {
			return "redirect:/login";
		}
	}
}
