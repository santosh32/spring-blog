package in.spring4buddies.application.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/PathVariable")
public class PathVariableController {

	@RequestMapping(value = "/{name}/{address}/{city}/{state}/{country}", method = RequestMethod.GET)
	public String showEmployeeByPathVariable(ModelMap model, 
			@PathVariable(value = "name") String name, 
			@PathVariable(value = "address") String line,
			@PathVariable String city, 
			@PathVariable String state, 
			@PathVariable(value = "country") String country) {

		String message = String.format("%s, %s, %s, %s, %s", name, line, city, state, country);
		model.addAttribute("message", message);
		
		return "displayPathVariable";
	}
	
	@RequestMapping(value = "/{name}/{address}", method = RequestMethod.GET)
	public String showEmployeeByMap(@PathVariable Map<String, String> varsMap, ModelMap model) {
		model.addAttribute("message", varsMap.toString());
		return "displayPathVariable";
	}
	
//	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
//	public String showEmployeeName(@PathVariable String name, ModelMap model) {
//		model.addAttribute("message", name);
//		return "displayPathVariable";
//	}
//
//	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
//	public String showEmployeeId(@PathVariable String id, ModelMap model) {
//		model.addAttribute("message", id);
//		return "displayPathVariable";
//	}
	
	@RequestMapping(value = "{name:[a-zA-Z]+}", method = RequestMethod.GET)
	public String showEmployeeName(@PathVariable String name, ModelMap model) {
		model.addAttribute("message", "This is from showEmployeeName() - " + name);
		return "displayPathVariable";
	}

	@RequestMapping(value = "{id:[0-9]+}", method = RequestMethod.GET)
	public String showEmployeeId(@PathVariable String id, ModelMap model) {
		model.addAttribute("message", "This is from showEmployeeId() - " + id);
		return "displayPathVariable";
	}

}