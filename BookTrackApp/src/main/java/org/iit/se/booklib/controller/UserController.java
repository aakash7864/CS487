package org.iit.se.booklib.controller;


import javax.servlet.http.HttpSession;

import org.iit.se.booklib.model.User;
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
public class UserController {
    @Autowired
    private UserManager userService;


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model, HttpSession session) {
        model.addAttribute("userForm", new User());
        model.addAttribute("userRole", ImmutableList.of("Admin","Student","Teacher"));
        if (session != null) {
    	    session.invalidate();
    	}
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model , HttpSession session) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.addUser(userForm);
        
        if(userForm.getRole().equals("Admin")){
    		session.setAttribute("userId", userForm.getUserId());
    		session.setAttribute("role", userForm.getRole());
    		return "redirect:/admin";
    	}else if(userForm.getRole().equals("Student")){
    		session.setAttribute("userId", userForm.getUserId());
    		session.setAttribute("role", userForm.getRole());
    		return "redirect:/student";
    	}else if(userForm.getRole().equals("Teacher")){
    		session.setAttribute("userId", userForm.getUserId());
    		session.setAttribute("role", userForm.getRole());
    		return "redirect:/teacher";
    	}
        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout , HttpSession session) {
    	
    	if (session != null) {
    	    session.invalidate();
    	}
    	
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String username,@RequestParam String password,@RequestParam String role,Model model,HttpSession session) {
        if(userService.isExist(username, password, role)){
        	if(role.equals("Admin")){
        		session.setAttribute("userId", username);
        		session.setAttribute("role", role);
        		return "redirect:/admin";
        	}else if(role.equals("Student")){
        		session.setAttribute("userId", username);
        		session.setAttribute("role", role);
        		return "redirect:/student";
        	}else if(role.equals("Teacher")){
        		session.setAttribute("userId", username);
        		session.setAttribute("role", role);
        		return "redirect:/teacher";
        	}
        	return "redirect:/welcome";
        }
        model.addAttribute("error", "Your username and password is invalid.");
        return "login";
    }
    
    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }
    @RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
    public String logout(HttpSession session) {
    	if (session != null) {
    	    session.invalidate();
    	}
        return "login";
    }
}