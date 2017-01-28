package in.spring4buddies.application.dao;

import in.spring4buddies.application.model.Customer;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class CustomerDaoImpl implements CustomerDao {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void insertCustomer(Customer customer) {
		String query = "insert into Customer (cust_id, name, salary, dept) values (?, ?, ?, ?)";
		Object[] inputs = new Object[] { customer.getCust_Id(), customer.getName(), customer.getSalary(), customer.getDept() };
		jdbcTemplate.update(query, inputs);
	}

	@Override
	public void updateCustomer(Customer customer) {
		String query = "update Customer set salary = ? where cust_id = ?";
		Object[] inputs = new Object[] { customer.getSalary(), customer.getCust_Id() };
		jdbcTemplate.update(query, inputs);
	}

	@Override
	public void removeCustomer(int custId) {
		String query = "delete from Customer where cust_id = ?";
		Object[] inputs = new Object[] { custId };
		jdbcTemplate.update(query, inputs);
	}

	@Override
	public Customer findCustomerById(int custId) {
		String query = "select * from Customer where cust_id=?";
		Object[] inputs = new Object[] { custId };
		Customer Customer = jdbcTemplate.queryForObject(query, inputs, new BeanPropertyRowMapper<Customer>(Customer.class));
		return Customer;
	}

	@Override
	public List<Customer> findAll() {
		String query = "select * from Customer";
		List<Customer> Customers = jdbcTemplate.query(query, new BeanPropertyRowMapper<Customer>(Customer.class));
		return Customers;
	}
}
