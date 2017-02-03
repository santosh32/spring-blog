package in.spring4buddies.application.helper;

import in.spring4buddies.application.model.Address;
import in.spring4buddies.application.model.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CustomerMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {

		Customer customer = new Customer();
		customer.setCustId(rs.getLong("CUST_ID"));
		customer.setName(rs.getString("NAME"));

		Address address = new Address();
		address.setLine1(rs.getString("ADDRESS"));
		address.setCity(rs.getString("CITY"));
		address.setState(rs.getString("STATE"));
		address.setZipCd(rs.getString("ZIP_CD"));

		customer.setAddress(address);
		return customer;
	}

}