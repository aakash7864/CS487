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
				"INSERT INTO USER(userId, passowrd, role, email, phoneNo,address,city,created_date,firstName,lastName,country,studentId,profId,ParentName,parentsAddress,parentsContant,courseId ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
				user.getUserId(), user.getPassowrd(), user.getRole(), user.getEmail(), user.getPhoneNo(),
				user.getAddress(), user.getCity(), new Date(), user.getFirstName(), user.getLastName(),
				user.getCountry(), user.getStudentId(), user.getProfId(), user.getParentsnName(), user.getParentsAdd(),
				user.getParentsContant(), user.getCourseId());

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
				user.setFirstName((String) (row.get("firstName")));
				user.setLastName((String) (row.get("lastName")));
				user.setCountry((String) (row.get("country")));
				user.setStudentId((String) (row.get("studentId")));
				user.setProfId((String) (row.get("profId")));
				user.setParentsnName((String) (row.get("ParentName")));
				user.setParentsAdd((String) (row.get("parentsAddress")));
				user.setParentsContant((String) (row.get("parentsContant")));
				user.setCourseId((String) (row.get("courseId")));
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
				user.setFirstName((String) (row.get("firstName")));
				user.setLastName((String) (row.get("lastName")));
				user.setCountry((String) (row.get("country")));
				user.setStudentId((String) (row.get("studentId")));
				user.setProfId((String) (row.get("profId")));
				user.setParentsnName((String) (row.get("ParentName")));
				user.setParentsAdd((String) (row.get("parentsAddress")));
				user.setParentsContant((String) (row.get("parentsContant")));
				user.setCourseId((String) (row.get("courseId")));
				users.add(user);
			}
		}
		return users;
	}

}
