package org.iit.se.booklib.service;

import java.util.List;

import org.iit.se.booklib.model.User;

public interface UserManager {

	boolean isExist(User user);

	User getUserByName(String userName);
	
	void addUser(User user);
	
	List<User> getUsers();

}
