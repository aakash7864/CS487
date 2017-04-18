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
public class TeacherController {

	@Autowired
	UserManager userManager;
	@Autowired
	BookManager bookManager;
	
	@RequestMapping(value = "/teacher", method = RequestMethod.GET)
    public String adminPage(Model model,HttpSession session) {
		if(session.getAttribute("userId")!=null && session.getAttribute("role")!=null &&  session.getAttribute("role").equals("Teacher")){
			User user = userManager.getUserByName((String) session.getAttribute("userId"));
			model.addAttribute("user",user);
			model.addAttribute("requestedBook", bookManager.getRequestedBookForTeacher(user.getUserId()));
			return "teacher";
		}else{
			return "login";
		}
     
    }
	
	@RequestMapping(value = "/teacher/checkoutBook", method = RequestMethod.POST)
	public String requestBook(@RequestParam String studentId,@RequestParam String bookNumber, HttpSession session) {
		if (session.getAttribute("userId") != null && session.getAttribute("role") != null
				&& session.getAttribute("role").equals("Teacher")) {
			bookManager.checkoutBook(studentId, bookNumber);
			return "redirect:/teacher";
		} else {
			return "redirect:/login";
		}
	}
	
	@RequestMapping(value = "/teacher/account", method = RequestMethod.GET)
	public String studentAccPage(Model model, HttpSession session) {
		if (session.getAttribute("userId") != null && session.getAttribute("role") != null
				&& session.getAttribute("role").equals("Teacher")) {
			User user = userManager.getUserByName((String) session.getAttribute("userId"));
			model.addAttribute("user", user);
			return "teacherAccount";
		} else {
			return "redirect:/login";
		}
	}
}
