package org.iit.se.booklib.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.iit.se.booklib.dao.UserDao;
import org.iit.se.booklib.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManagerImpl implements UserManager {

	@Autowired
	UserDao userDao;

	public boolean isExist(String userId,String password, String role) {
		boolean isExist = false;
		if (StringUtils.isNotEmpty(userId) && StringUtils.isNotEmpty(password)
				&& StringUtils.isNotEmpty(role)) {
			List<User> users = userDao.getUsers();
			for (User user : users) {
				if (user.getUserId().equals(userId)
						&& user.getPassowrd().equals(password)
						&& user.getRole().equals(role)) {
					isExist = true;
				}
			}
		}
		return isExist;
	}

	public User getUserByName(String userName) {
		List<User> users = userDao.getUserById(userName);
		return users.get(0);
	}

	public void addUser(User user) {
		if (user != null) {
			if (StringUtils.isNotEmpty(user.getUserId()) && StringUtils.isNotEmpty(user.getPassowrd())
					&& StringUtils.isNotEmpty(user.getRole())) {
				userDao.addUser(user);
			} else {
				System.out.println("unable to add user");
			}
		} else {
			System.out.println("unable to add user");
		}

	}

	public List<User> getUsers() {
		return userDao.getUsers();
	}

}
