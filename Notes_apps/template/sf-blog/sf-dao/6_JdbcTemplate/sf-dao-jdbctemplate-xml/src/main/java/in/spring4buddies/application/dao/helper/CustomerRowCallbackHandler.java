package in.spring4buddies.application.dao.helper;

import in.spring4buddies.application.model.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowCallbackHandler;

public class CustomerRowCallbackHandler implements RowCallbackHandler {

	private List<Customer> customers;

	public CustomerRowCallbackHandler() {
		customers = new ArrayList<>();
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	@Override
	public void processRow(ResultSet rs) throws SQLException {
		while (rs.next()) {
			Customer customer = new Customer(rs.getInt("cust_id"), rs.getString("name"), rs.getInt("salary"), rs.getString("dept"));
			customers.add(customer);
		}
	}
}