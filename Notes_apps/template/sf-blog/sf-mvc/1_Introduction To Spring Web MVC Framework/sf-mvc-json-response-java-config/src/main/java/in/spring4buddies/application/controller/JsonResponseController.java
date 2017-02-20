package in.spring4buddies.application.controller;

import in.spring4buddies.application.model.Employees;
import in.spring4buddies.application.model.Employees.Employee;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/json")
public class JsonResponseController {

	@RequestMapping(value = "/employee", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Employee getEmployeeData() {
		return getEmployee();
	}

	private Employee getEmployee() {
		Employee employee = new Employee();
		employee.setId(001);
		employee.setFirstName("Steve");
		employee.setLastName("Rob");
		employee.setAge(30);
		employee.setSalary(4500);
		return employee;
	}

	@RequestMapping(value = "/employees", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Employees getEmployeesData() {

		Employees employees = new Employees();
		employees.getEmployees().add(getEmployee());
		employees.getEmployees().add(getEmployee());
		employees.getEmployees().add(getEmployee());

		return employees;
	}

}
