package in.spring4buddies.application.dao;

import in.spring4buddies.application.model.Employee;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDaoImpl implements EmployeeDao {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void insertEmployee(Employee emp) {
		String query = "insert into employee (name,salary,dept) values (?,?,?)";
		jdbcTemplate = new JdbcTemplate(dataSource);
		Object[] inputs = new Object[] { emp.getName(), emp.getSalary(), emp.getDept() };
		jdbcTemplate.update(query, inputs);
	}

	@Override
	public void updateEmployee(Employee emp) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeEmployee(int empId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Employee findEmployeeById(int empId) {
		// TODO Auto-generated method stub
		return null;
	}
}
