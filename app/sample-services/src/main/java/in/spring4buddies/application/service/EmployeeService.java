package in.spring4buddies.application.service;

import in.spring4buddies.application.domain.Employee;

import java.util.List;

public interface EmployeeService {

	Employee save(Employee employee);

	List<Employee> getEmployeeList();

}
