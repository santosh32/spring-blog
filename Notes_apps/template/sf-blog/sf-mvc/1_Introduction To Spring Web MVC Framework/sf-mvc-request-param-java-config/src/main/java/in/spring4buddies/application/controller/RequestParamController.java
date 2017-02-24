package in.spring4buddies.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/RequestParam")
public class RequestParamController {

	@RequestMapping(method = RequestMethod.GET)
	public String showEmployeeDetails(ModelMap model, @RequestParam(value = "name") String name,
			@RequestParam(value = "address") String line,
			@RequestParam String city, 
			@RequestParam(value = "state") String state, 
			@RequestParam(value = "country") String country) {

		String message = String.format("%s, %s, %s, %s, %s", name, line, city, state, country);
		model.addAttribute("message", message);
		
		return "displayRequestParam";
	}

}