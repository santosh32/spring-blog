package in.spring4buddies.application.dao;

import in.spring4buddies.application.model.Customer;
import in.spring4buddies.application.model.Employee;
import in.spring4buddies.application.model.Invoice;
import in.spring4buddies.application.model.Order;
import in.spring4buddies.application.model.Staff;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;

public class CommonDaoImpl implements CommonDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	private final String SQL_STAFF_INSERT = "INSERT INTO STAFF(STAFF_ID, LAST_NAME, FIRST_NAME, CITY, STATE, HOME_PHONE) values(?, ?, ?, ?, ?, ?)";
	private final String SQL_CUSTOMER_INSERT = "Insert into customer (customer_Id, contact, address, city, firstOrder, state, zipCode, country, phone, name ) values (?,?,?,?,?,?,?,?,?,?)";
	private final String SQL_EMPLOYEE_INSERT = "insert into Employee (emp_Id, hireDate, salary, dept, jobcode, sex, birthDate, lastName, firstName, middleName, phone ) "
			+ "values (:empId, :hireDate, :salary, :dept, :jobcode, :sex, :birthDate, :lastName, :firstName, :middleName, :phone )";
	private final String SQL_INVOICE_INSERT = "insert into Invoice (invoice_Id, billedTo, amtBilled, country, amtInUS, billedBy, billedOn, paidOn ) values ( ?,?,?,?,?,?,?,? )";
	private final String SQL_ORDER_INSERT = "insert into OrderItem (order_Id, stockId, length, fabCharges, shipTo, orderDate, shipped, takenBy, proccessdBy, specinstr ) "
			+ "values (:orderId, :stockId, :length, :fabCharges, :shipTo, :orderDate, :shipped, :takenBy, :proccessdBy, :specinstr)";

	@Override
	public int[] insertCustomer(List<Customer> customers) {
		List<Object[]> batch = new ArrayList<>();
		for (Customer customer : customers) {
			Object[] values = new Object[] { customer.getCustomerId(), customer.getContact(), customer.getAddress(), customer.getCity(),
					customer.getFirstOrder(), customer.getState(), customer.getZipCode(), customer.getCountry(), customer.getPhone(),
					customer.getName() };
			batch.add(values);
		}
		return jdbcTemplate.batchUpdate(SQL_CUSTOMER_INSERT, batch);
	}

	@Override
	public int[] insertEmployee(List<Employee> employees) {
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(employees.toArray());
		return namedParameterJdbcTemplate.batchUpdate(SQL_EMPLOYEE_INSERT, batch);
	}

	@Override
	public int[][] insertInvoice(List<Invoice> invoices) {
		return jdbcTemplate.batchUpdate(SQL_INVOICE_INSERT, invoices, 100, new ParameterizedPreparedStatementSetter<Invoice>() {
			@Override
			public void setValues(PreparedStatement pStmt, Invoice invoice) throws SQLException {
				pStmt.setInt(1, invoice.getInvoiceId());
				pStmt.setString(2, invoice.getBilledTo());
				pStmt.setString(3, invoice.getAmtBilled());
				pStmt.setString(4, invoice.getCountry());
				pStmt.setString(5, invoice.getAmtInUS());
				pStmt.setString(6, invoice.getBilledBy());
				pStmt.setString(7, invoice.getBilledOn());
				pStmt.setString(8, invoice.getPaidOn());
			}
		});
	}

	@Override
	public int[] insertOrder(List<Order> orders) {
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(orders.toArray());
		return namedParameterJdbcTemplate.batchUpdate(SQL_ORDER_INSERT, batch);
	}

	@Override
	public int[] insertStaff(final List<Staff> staffs) {

		return jdbcTemplate.batchUpdate(SQL_STAFF_INSERT, new BatchPreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pStmt, int i) throws SQLException {
				Staff staff = staffs.get(i);
				pStmt.setInt(1, staff.getStaff_Id());
				pStmt.setString(2, staff.getLast_name());
				pStmt.setString(3, staff.getFirst_Name());
				pStmt.setString(4, staff.getCity());
				pStmt.setString(5, staff.getState());
				pStmt.setString(6, staff.getHome_phone());
			}

			@Override
			public int getBatchSize() {
				return staffs.size();
			}
		});
	}
}
