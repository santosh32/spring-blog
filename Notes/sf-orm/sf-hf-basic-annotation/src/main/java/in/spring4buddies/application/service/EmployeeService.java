package in.spring4buddies.application.service;

import in.spring4buddies.application.model.Employee;

import java.util.List;

public interface EmployeeService {

	void saveEmployee(Employee employee);

	void updateEmployee(Employee employee);

	void deleteEmployeeBySsn(String ssn);

	List<Employee> findAllEmployees();

//	Employee findBySsn(String ssn);

}
