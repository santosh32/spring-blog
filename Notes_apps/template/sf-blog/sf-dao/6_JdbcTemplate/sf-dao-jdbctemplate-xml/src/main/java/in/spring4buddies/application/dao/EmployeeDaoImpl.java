package in.spring4buddies.application.dao;

import in.spring4buddies.application.dao.helper.EmployeeRowMapper;
import in.spring4buddies.application.model.Employee;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDaoImpl implements EmployeeDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void insertEmployee(Employee emp) {
		String query = "insert into employee (emp_id, name, salary, dept) values (?, ?, ?, ?)";
		Object[] inputs = new Object[] { emp.getEmpId(), emp.getName(), emp.getSalary(), emp.getDept() };
		jdbcTemplate.update(query, inputs);
	}

	@Override
	public void updateEmployee(Employee emp) {
		String query = "update employee set salary = ? where emp_id = ?";
		Object[] inputs = new Object[] { emp.getSalary(), emp.getEmpId() };
		jdbcTemplate.update(query, inputs);
	}

	@Override
	public void removeEmployee(int empId) {
		String query = "delete from employee where emp_id = ?";
		Object[] inputs = new Object[] { empId };
		jdbcTemplate.update(query, inputs);
	}

	@Override
	public Employee findEmployeeById(int empId) {
		String query = "select * from employee where emp_id=?";
		Object[] inputs = new Object[] { empId };
		Employee employee = jdbcTemplate.queryForObject(query, inputs, new EmployeeRowMapper());
		return employee;
	}

	@Override
	public List<Employee> findAll_query_RowMapper() {
		String query = "select * from employee";
		List<Employee> employees = jdbcTemplate.query(query, new EmployeeRowMapper());
		return employees;
	}
}
