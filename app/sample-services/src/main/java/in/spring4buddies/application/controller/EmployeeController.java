package in.spring4buddies.application.controller;

import in.spring4buddies.application.domain.Employee;
import in.spring4buddies.application.service.EmployeeService;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	private final EmployeeService employeeService;

	@Inject
	public EmployeeController(final EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public List<Employee> listEmployees() {
		
		List<Employee> employees = employeeService.getEmployeeList();
		return employees;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public void addEmployee(
			@RequestParam(value = "employeeName", required = false) String employeeName,
			@RequestParam(value = "employeeId", required = false) String employeeId,
			@RequestParam(value = "employeeCity", required = false) String employeeCity) {
		
		Employee employee = new Employee(employeeId, employeeName, employeeCity);
		employeeService.save(employee);
	}
}
