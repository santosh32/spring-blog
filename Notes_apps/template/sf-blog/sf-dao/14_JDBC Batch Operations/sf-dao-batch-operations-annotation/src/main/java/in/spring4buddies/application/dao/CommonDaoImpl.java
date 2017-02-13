package in.spring4buddies.application.dao;

import in.spring4buddies.application.model.Employee;
import in.spring4buddies.application.model.Invoice;
import in.spring4buddies.application.model.Order;
import in.spring4buddies.application.model.Staff;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

public class CommonDaoImpl implements CommonDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_STAFF_INSERT = "INSERT INTO Employee(STAFF_ID, LAST_NAME, FIRST_NAME, CITY, STATE, HOME_PHONE) values(?, ?, ?, ?, ?, ?)";

//	public void insertEmployee(final List<Staff> staffs) {
//
//		jdbcTemplate.batchUpdate(SQL_STAFF_INSERT, new BatchPreparedStatementSetter() {
//			@Override
//			public void setValues(PreparedStatement pStmt, int i) throws SQLException {
//				Staff staff = staffs.get(i);
//				pStmt.setInt(1, staff.getStaff_Id());
//				pStmt.setString(2, staff.getLast_name());
//				pStmt.setString(3, staff.getFirst_Name());
//				pStmt.setString(4, staff.getCity());
//				pStmt.setString(5, staff.getState());
//				pStmt.setString(6, staff.getHome_phone());
//			}
//
//			@Override
//			public int getBatchSize() {
//				return staffs.size();
//			}
//		});
//	}

	@Override
	public void insertEmployee(List<Employee> employees) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertInvoice(List<Invoice> invoices) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertOrder(List<Order> orders) {
		// TODO Auto-generated method stub
		
	}
}
