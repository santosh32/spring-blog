package in.spring4buddies.application.dao;

import in.spring4buddies.application.model.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapper implements RowMapper<Employee> {
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();
		employee.setEmpId(rs.getInt("EMP_ID"));
		employee.setName(rs.getString("NAME"));
		employee.setSalary(rs.getInt("SALARY"));
		employee.setDept(rs.getString("DEPT"));
		return employee;
	}

}