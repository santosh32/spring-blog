package in.spring4buddies.application.dao;

import in.spring4buddies.application.model.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class CustomerResultSetExtractor implements ResultSetExtractor<List<Customer>> {

	@Override
	public List<Customer> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Customer> customers = new ArrayList<>();
		while (rs.next()) {
			Customer customer = new Customer(rs.getInt("cust_id"), rs.getString("name"), rs.getInt("salary"), rs.getString("dept"));
			customers.add(customer);
		}
		return customers;
	}
}