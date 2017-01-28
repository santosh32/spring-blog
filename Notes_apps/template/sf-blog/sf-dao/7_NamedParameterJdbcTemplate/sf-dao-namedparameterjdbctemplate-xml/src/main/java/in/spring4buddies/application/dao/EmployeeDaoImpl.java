package in.spring4buddies.application.dao;

import in.spring4buddies.application.dao.helper.EmployeeRowMapper;
import in.spring4buddies.application.model.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class EmployeeDaoImpl implements EmployeeDao {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public Map<String, Object> getParameters(Employee emp) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("emp_id", emp.getEmpId());
		parameters.put("name", emp.getName());
		parameters.put("salary", emp.getSalary());
		parameters.put("dept", emp.getDept());
		return parameters;
	}

	@Override
	public void insertEmployee(Employee emp) {
		String sql = "insert into employee (emp_id, name, salary, dept) values (:emp_id, :name, :salary, :dept)";
		namedParameterJdbcTemplate.update(sql, getParameters(emp));
	}

	@Override
	public void updateEmployee(Employee emp) {
		String query = "update employee set salary = :salary where emp_id = :emp_id";
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("emp_id", emp.getEmpId());
		parameters.put("salary", emp.getSalary());
		namedParameterJdbcTemplate.update(query, parameters);
	}

	@Override
	public void removeEmployee(int empId) {
		String query = "delete from employee where emp_id = :emp_id";
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("emp_id", empId);
		namedParameterJdbcTemplate.update(query, parameters);
	}

	@Override
	public Employee findEmployeeById(int empId) {
		String sql = "select * from employee where emp_id= :emp_id";
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("emp_id", empId);
		Employee employee = namedParameterJdbcTemplate.queryForObject(sql, parameters, new EmployeeRowMapper());
		return employee;
	}

	@Override
	public List<Employee> findAll_query_RowMapper() {
		String query = "select * from employee";
		List<Employee> employees = namedParameterJdbcTemplate.query(query, new EmployeeRowMapper());
		return employees;
	}
}
