package in.spring4buddies.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/PathVariable")
public class PathVariableController {

	@RequestMapping(value = "/{name}/{address}/{city}/{state}/{country}", method = RequestMethod.GET)
	public String showEmployeeDetails(ModelMap model, 
			@PathVariable(value = "name") String name, 
			@PathVariable(value = "address") String address,
			@PathVariable String city, 
			@PathVariable String state, 
			@PathVariable(value = "country") String country) {

		String message = String.format("%s, %s, %s, %s, %s", name, address, city, state, country);
		model.addAttribute("message", message);
		
		return "displayPathVariable";
	}
	
	@RequestMapping(value = "/employee/{name}/{email:.+}", method = RequestMethod.GET)
	public String addEmployee(ModelMap model,
			@PathVariable(value = "name") String name, 
			@PathVariable(value = "email") String email) {

		return "employee";
	}

}