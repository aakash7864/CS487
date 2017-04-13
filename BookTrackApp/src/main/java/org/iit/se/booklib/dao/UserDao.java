package org.iit.se.booklib.dao;

import java.util.List;

import org.iit.se.booklib.model.User;

public interface UserDao {

	void addUser(User user);
	
	List<User> getUsers();
	
	List<User> getUserById(String UserId);
	
	
}
