package org.iit.se.booklib.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.iit.se.booklib.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserManagerImpl implements UserManager {

	List<User> users = new ArrayList<User>();

	public boolean isExist(User searchUser) {
		boolean isExist = false;
		if (StringUtils.isNotEmpty(searchUser.getUserId()) && StringUtils.isNotEmpty(searchUser.getPassowrd())
				&& StringUtils.isNotEmpty(searchUser.getRole())) {
			for (User user : users) {
				if (user.getUserId().equals(searchUser.getUserId())
						&& user.getPassowrd().equals(searchUser.getPassowrd())
						&& user.getRole().equals(searchUser.getRole())) {
					isExist = true;
				}
			}
		}
		return isExist;
	}

	public User getUserByName(String userName) {
		User user = null;
		if (StringUtils.isNotEmpty(userName)) {
			for (User currUser : users) {
				if (currUser.getUserId().equals(userName)) {
					user = currUser;
				}
			}
		}
		return user;
	}

	public void addUser(User user) {
		if (user != null) {
			if (StringUtils.isNotEmpty(user.getUserId()) && StringUtils.isNotEmpty(user.getPassowrd())
					&& StringUtils.isNotEmpty(user.getRole())) {
				users.add(user);
			} else {
				System.out.println("unable to add user");
			}
		} else {
			System.out.println("unable to add user");
		}

	}

	public List<User> getUsers() {	
		return users;
	}

}
