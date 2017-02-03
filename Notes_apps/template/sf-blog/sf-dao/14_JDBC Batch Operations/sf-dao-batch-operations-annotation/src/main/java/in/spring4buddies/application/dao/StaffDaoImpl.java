package in.spring4buddies.application.dao;

import in.spring4buddies.application.model.Staff;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

public class StaffDaoImpl implements StaffDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final int INSERT_BATCH_SIZE = 2;
	private final String SQL_STAFF_INSERT = "INSERT INTO staff(staff_id, lname, fname, city, state, hphone) values(?, ?, ?, ?, ?, ?)";

	@Override
	public void insert(List<Staff> staffs) {
		for (int i = 0; i < staffs.size(); i += INSERT_BATCH_SIZE) {

			final List<Staff> batchList = staffs.subList(i, i + INSERT_BATCH_SIZE > staffs.size() ? staffs.size() : i + INSERT_BATCH_SIZE);

			jdbcTemplate.batchUpdate(SQL_STAFF_INSERT, new BatchPreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement pStmt, int j) throws SQLException {
					Staff staff = batchList.get(j);
					pStmt.setInt(1, staff.getStaffId());
					pStmt.setString(2, staff.getlLame());
					pStmt.setString(3, staff.getfName());
					pStmt.setString(4, staff.getCity());
					pStmt.setString(5, staff.getState());
					pStmt.setString(6, staff.gethPhone());
				}

				@Override
				public int getBatchSize() {
					return batchList.size();
				}
			});
		}
	}
}
