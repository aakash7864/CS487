package org.iit.se.booklib.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.iit.se.booklib.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void addUser(User user) {
		jdbcTemplate.update(
				"INSERT INTO USER(userId, passowrd, role, email, phoneNo,address,city, created_date) VALUES (?,?,?,?,?,?,?,?)",
				user.getUserId(), user.getPassowrd(), user.getRole(), user.getEmail(), user.getPhoneNo(),
				user.getAddress(), user.getCity(), new Date());

	}

	@Override
	public List<User> getUsers() {

		String sql = "SELECT * FROM USER";

		List<User> users = new ArrayList<User>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		if (CollectionUtils.isNotEmpty(rows)) {
			for (Map row : rows) {
				User user = new User();
				user.setUserId((String) (row.get("userId")));
				user.setPassowrd((String) (row.get("passowrd")));
				user.setRole((String) (row.get("role")));
				user.setEmail((String) (row.get("email")));
				user.setPhoneNo((String) (row.get("phoneNo")));
				user.setAddress((String) (row.get("address")));
				user.setCity((String) (row.get("city")));
				users.add(user);
			}
		}
		return users;
	}

	@Override
	public List<User> getUserById(String UserId) {

		String sql = "SELECT * FROM USER WHERE userId = '" + UserId + "'";

		List<User> users = new ArrayList<User>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		if (CollectionUtils.isNotEmpty(rows)) {
			for (Map row : rows) {
				User user = new User();
				user.setUserId((String) (row.get("userId")));
				user.setPassowrd((String) (row.get("passowrd")));
				user.setRole((String) (row.get("role")));
				user.setEmail((String) (row.get("email")));
				user.setPhoneNo((String) (row.get("phoneNo")));
				user.setAddress((String) (row.get("address")));
				user.setCity((String) (row.get("city")));
				users.add(user);
			}
		}
		return users;
	}

}
