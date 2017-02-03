package in.spring4buddies.application.helper;

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
		customer.setAddress(rs.getString("ADDRESS"));
		customer.setCity(rs.getString("CITY"));
		customer.setState(rs.getString("STATE"));
		customer.setZipCd(rs.getString("ZIP_CD"));
		return customer;
	}

}