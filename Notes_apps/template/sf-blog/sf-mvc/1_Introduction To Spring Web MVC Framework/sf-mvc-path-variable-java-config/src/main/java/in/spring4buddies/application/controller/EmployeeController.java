package in.spring4buddies.application.controller;

import in.spring4buddies.application.command.Employee;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@RequestMapping(value = "/{name}/{address}/{city}/{state}/{country}", method = RequestMethod.GET)
	public String showEmployeeDetails(ModelMap model, @PathVariable(value = "name") String name, 
			@PathVariable(value = "address") String address,
			@PathVariable(value = "city") String city, 
			@PathVariable(value = "state") String state, 
			@PathVariable(value = "country") String country) {

		Employee employee = new Employee(100l, name, address, city, state, country);
		model.addAttribute("employee", employee);
		return "employee";
	}
}