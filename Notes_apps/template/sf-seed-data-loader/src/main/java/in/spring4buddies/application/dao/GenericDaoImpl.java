package in.spring4buddies.application.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class GenericDaoImpl<T> implements GenericDao<T> {

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public void insert(List<T> data, Class<T> clazz) {
		String query = "insert into employee (emp_id, name, salary, dept) values (:emp_id, :, :, :)";
		namedParameterJdbcTemplate.update(query, new HashMap());
	}

	@Override
	public List<T> getAll(Class<T> clazz) {
		String query = "select * from " + clazz.getSimpleName();
		return namedParameterJdbcTemplate.query(query, new BeanPropertyRowMapper<T>(clazz));
	}

	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

}
