package in.spring4buddies.application.controller;

import in.spring4buddies.application.command.Employee;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@RequestMapping(method = RequestMethod.GET)
	public String showEmployeeDetails(ModelMap model, @RequestParam(value = "name") String name,
			@RequestParam(value = "address") String address,
			@RequestParam(value = "city") String city, 
			@RequestParam(value = "state") String state, 
			@RequestParam(value = "country") String country) {

		Employee employee = new Employee(100l, name, address, city, state, country);
		model.addAttribute("employee", employee);
		return "employee";
	}

}