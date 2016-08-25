package in.spring4buddies.application.rest.controller;

import in.spring4buddies.application.rest.model.Employee;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("employees")
public class EmployeeController {

	Employee employee = new Employee();

	//Accept : application/xml application/json
	@RequestMapping(value = "/{name}", method = RequestMethod.GET, produces = {
			"application/json", "application/xml" })
	public @ResponseBody Employee getEmployeeInJSON(@PathVariable String name) {

		employee.setName(name);
		employee.setEmail("employee1@spring4buddies.in");

		return employee;

	}

	@RequestMapping(value = "/{name}.xml", method = RequestMethod.GET, produces = "application/xml")
	public @ResponseBody Employee getEmployeeInXML(@PathVariable String name) {

		employee.setName(name);
		employee.setEmail("employee1@spring4buddies.in");

		return employee;

	}

}