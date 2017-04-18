package org.iit.se.booklib.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.iit.se.booklib.model.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Courses> getAll(){
		String sql = "SELECT * FROM COURSE";

		List<Courses> cources = new ArrayList<Courses>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		if (CollectionUtils.isNotEmpty(rows)) {
			for (Map row : rows) {
				Courses courses= new Courses();
				courses.setCourseId((String) (row.get("courseId")));
				courses.setCourseName((String) (row.get("courseName")));
				cources.add(courses);
			}
		}
		return cources;
	}
}
