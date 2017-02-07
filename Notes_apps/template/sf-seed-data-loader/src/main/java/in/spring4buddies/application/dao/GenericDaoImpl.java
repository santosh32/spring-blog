package in.spring4buddies.application.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class GenericDaoImpl<T> implements GenericDao<T> {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void insert(List<T> data, Class<T> clazz) {
		String query = "insert into employee (emp_id, name, salary, dept) values (?, ?, ?, ?)";
		Object[] inputs = new Object[] {};
		jdbcTemplate.update(query, inputs);
	}

	@Override
	public List<T> getAll(Class<T> clazz) {
		String query = "select * from " + clazz.getSimpleName();
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<T>(clazz));
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
