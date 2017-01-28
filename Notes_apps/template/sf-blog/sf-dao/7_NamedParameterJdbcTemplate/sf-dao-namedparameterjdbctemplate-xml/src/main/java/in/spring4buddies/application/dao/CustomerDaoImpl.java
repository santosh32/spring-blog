package in.spring4buddies.application.dao;

import in.spring4buddies.application.dao.helper.CustomerResultSetExtractor;
import in.spring4buddies.application.model.Customer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class CustomerDaoImpl implements CustomerDao {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public Customer findCustomerById_queryForObject(int custId) {
		String query = "select * from Customer where cust_id=:cust_id";
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("cust_id", custId);
		Customer customer = namedParameterJdbcTemplate.queryForObject(query, parameters, new BeanPropertyRowMapper<Customer>(Customer.class));
		return customer;
	}

	@Override
	public List<Map<String, Object>> findCustomerByDept_queryForList(String dept) {
		String query = "select * from Customer where dept=:dept";
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("dept", dept);
		SqlParameterSource paramSource = new MapSqlParameterSource(parameters);
		return namedParameterJdbcTemplate.queryForList(query, paramSource);
	}

	@Override
	public Map<String, Object> findCustomerByName_queryForMap(String name) {
		String query = "select * from Customer where name like :name";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("name", name);
		return namedParameterJdbcTemplate.queryForMap(query, paramSource);
	}

	@Override
	public List<Customer> findAll_query_BeanPropertyRowMapper() {
		String query = "select * from Customer";
		List<Customer> customers = namedParameterJdbcTemplate.query(query, new BeanPropertyRowMapper<Customer>(Customer.class));
		return customers;
	}

	@Override
	public List<Customer> findCustomerByDept_query_ResultSetExtractor(String dept) {
		String query = "select * from Customer where dept=:dept";
		
		Customer customer = new Customer();
		customer.setDept(dept);
		BeanPropertySqlParameterSource beanParamSource = new BeanPropertySqlParameterSource(customer);

		return namedParameterJdbcTemplate.query(query, beanParamSource, new CustomerResultSetExtractor());
	}

}
