package in.spring4buddies.application.service;

import in.spring4buddies.application.jpa.Employee;
import in.spring4buddies.application.jpa.EmployeeRepository;

public class EmployeeService {

	private EmployeeRepository employeeRepository;

	private EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;

	}

	public void save(Employee employee) {
		employeeRepository.save(employee);
	}
}
