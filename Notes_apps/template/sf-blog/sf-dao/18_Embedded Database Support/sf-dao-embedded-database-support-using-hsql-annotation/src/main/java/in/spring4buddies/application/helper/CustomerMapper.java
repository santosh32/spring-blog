package in.spring4buddies.application.helper;

import in.spring4buddies.application.model.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CustomerMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer();
		customer.setCustomerId(rs.getLong("CUSTOMER_ID"));
		customer.setCustomerName(rs.getString("CUSTOMER_NAME"));
		customer.setCustomerAddress(rs.getString("CUSTOMER_ADDRESS"));
		customer.setCustomerCity(rs.getString("CUSTOMER_CITY"));
		customer.setCustomerState(rs.getString("CUSTOMER_STATE"));
		customer.setCustomerZip(rs.getString("CUSTOMER_ZIP_POSTAL"));
		return customer;
	}

}