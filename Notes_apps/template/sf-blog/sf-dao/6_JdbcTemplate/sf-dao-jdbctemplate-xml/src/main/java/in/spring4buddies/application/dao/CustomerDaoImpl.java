package in.spring4buddies.application.dao;

import in.spring4buddies.application.model.Customer;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class CustomerDaoImpl implements CustomerDao {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Customer findCustomerById_queryForObject(int custId) {
		String query = "select * from Customer where cust_id=?";
		Object[] args = new Object[] { custId };
		Customer customer = jdbcTemplate.queryForObject(query, args, new BeanPropertyRowMapper<Customer>(Customer.class));
		return customer;
	}

	@Override
	public List<Customer> findAll_query() {
		String query = "select * from Customer";
		List<Customer> customers = jdbcTemplate.query(query, new BeanPropertyRowMapper<Customer>(Customer.class));
		return customers;
	}

	@Override
	public List<Map<String, Object>> findCustomerByDept_queryForList(String dept) {
		String query = "select * from Customer where dept=?";
		Object[] args = new Object[] { dept };
		return jdbcTemplate.queryForList(query, args);
	}

	@Override
	public Map<String, Object> findCustomerByName_queryForMap(String name) {
		String query = "select * from Customer where name like ?";
		Object[] args = new Object[] { name };
		return jdbcTemplate.queryForMap(query, args);
	}

}
