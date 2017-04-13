package org.iit.se.booklib.service;

import java.util.List;

import org.iit.se.booklib.model.User;

public interface UserManager {

	boolean isExist(String userId,String password, String role);

	User getUserByName(String userName);
	
	void addUser(User user);
	
	List<User> getUsers();

}
