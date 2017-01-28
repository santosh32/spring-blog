package in.spring4buddies.application.dao.helper;

import in.spring4buddies.application.model.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;

public class CustomerPreparedStatementCallback implements PreparedStatementCallback<List<Customer>> {

	@Override
	public List<Customer> doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
		List<Customer> customers = new ArrayList<>();
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Customer customer = new Customer(rs.getInt("cust_id"), rs.getString("name"), rs.getInt("salary"), rs.getString("dept"));
			customers.add(customer);
		}
		return customers;
	}
}