package in.spring4buddies.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.spring4buddies.application.command.Employee;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@RequestMapping(method = RequestMethod.GET)
	public String showEmployeeDetailsByRequestParam(Employee employee, Model model) {

		model.addAttribute("message", "RequestParam");
		model.addAttribute("employee", employee);

		return "employee";
	}

	@RequestMapping(value = "/{name}/{address}/{city}/{state}/{country}", method = RequestMethod.GET)
	public String showEmployeeDetailsByPathVariable(Employee employee, Model model) {

		model.addAttribute("message", "PathVariable");
		model.addAttribute("employee", employee);

		return "employee";
	}
}