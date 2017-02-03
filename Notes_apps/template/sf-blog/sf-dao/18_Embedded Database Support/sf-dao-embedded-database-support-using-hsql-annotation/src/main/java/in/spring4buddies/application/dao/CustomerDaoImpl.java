package in.spring4buddies.application.dao;

import static in.spring4buddies.application.helper.Constants.SQL_DELETE_CUSTOMER;
import static in.spring4buddies.application.helper.Constants.SQL_FIND_ALL_CUSTOMERS;
import static in.spring4buddies.application.helper.Constants.SQL_FIND_BY_CUST_ID;
import static in.spring4buddies.application.helper.Constants.SQL_NEW_CUSTOMER;
import static in.spring4buddies.application.helper.Constants.SQL_UPDATE_CUSTOMER;
import in.spring4buddies.application.helper.CustomerMapper;
import in.spring4buddies.application.model.Customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Customer findByCustomerId(long customerId) {
		Customer customer = jdbcTemplate.queryForObject(SQL_FIND_BY_CUST_ID, new CustomerMapper(), new Object[] { customerId });
		return customer;
	}

	@Override
	public List<Customer> findAllCustomers() {
		List<Customer> customers = jdbcTemplate.query(SQL_FIND_ALL_CUSTOMERS, new CustomerMapper());
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		jdbcTemplate.update(SQL_NEW_CUSTOMER, new Object[] { customer.getName(), customer.getAddress().getLine1(), customer.getAddress().getCity(),
				customer.getAddress().getState(), customer.getAddress().getZipCd() });
	}

	@Override
	public void updateCustomer(Customer customer) {
		jdbcTemplate.update(SQL_UPDATE_CUSTOMER, new Object[] { customer.getName(), customer.getAddress().getLine1(),
				customer.getAddress().getCity(), customer.getAddress().getState(), customer.getAddress().getZipCd(), customer.getCustId() });
	}

	@Override
	public void deleteCustomer(long customerId) {
		jdbcTemplate.update(SQL_DELETE_CUSTOMER, new Object[] { customerId });
	}

}