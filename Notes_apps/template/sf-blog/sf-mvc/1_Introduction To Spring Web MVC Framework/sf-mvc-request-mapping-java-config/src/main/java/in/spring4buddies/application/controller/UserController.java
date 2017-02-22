package in.spring4buddies.application.controller;

import in.spring4buddies.application.command.Employee;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping({ "/user", "/client" })
@Controller
public class UserController {

	@RequestMapping(value = "/{name}/{address}/{city}/{state}/{country}", method = RequestMethod.GET)
	public String showEmployee(ModelMap model, 
			@PathVariable(value = "name") String name, @PathVariable(value = "address") String address,
			@PathVariable(value = "city") String city, @PathVariable(value = "state") String state, 
			@PathVariable(value = "country") String country) {

		Employee employee = new Employee(name, address, city, state, country, null);
		model.addAttribute("employee", employee);
		return "employee";
	}

	@RequestMapping(value = "/{name}/{email:.+}", method = RequestMethod.GET)
	public String addEmployee(ModelMap model, @PathVariable(value = "name") String name, @PathVariable(value = "email") String email) {

		return "employee";
	}
}