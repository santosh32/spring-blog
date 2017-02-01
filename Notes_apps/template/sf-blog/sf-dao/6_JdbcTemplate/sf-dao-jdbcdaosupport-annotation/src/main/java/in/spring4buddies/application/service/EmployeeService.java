package in.spring4buddies.application.service;

import in.spring4buddies.application.model.Employee;

import java.util.List;

public interface EmployeeService {

	void insertEmployee(Employee emp);

	void updateEmployee(Employee emp);

	void removeEmployee(int empId);

	Employee findEmployeeById(int empId);

	List<Employee> findAll_query_RowMapper();
}
