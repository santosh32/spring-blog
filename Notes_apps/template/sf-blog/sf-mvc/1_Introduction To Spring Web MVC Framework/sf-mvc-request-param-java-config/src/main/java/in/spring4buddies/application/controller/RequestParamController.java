package in.spring4buddies.application.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/RequestParam")
public class RequestParamController {

	@RequestMapping(method = RequestMethod.GET)
	public String showEmployeeDetails(@RequestParam(value = "name") String name, 
			@RequestParam(value = "address") String line,
			@RequestParam String city,
			@RequestParam(value = "state", defaultValue="AP") String state, 
			@RequestParam(value = "country", required = false) String country, ModelMap model) {

		String message = String.format("%s, %s, %s, %s, %s", name, line, city, state, country);
		model.addAttribute("message", message);

		return "displayRequestParam";
	}

	@RequestMapping(value = "/map", method = RequestMethod.GET)
	public String showEmployeeByMap(@RequestParam Map<String, String> varsMap, ModelMap model) {
		
		model.addAttribute("message", varsMap.toString());
		
		return "displayRequestParam";
	}
	
	@RequestMapping(value = "/dateformat", method = RequestMethod.GET)
	public String showEmployeeByHireAndDOb(
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam(value = "dateOfBirth") Date dateOfBirth,
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam(value = "hireDate") Date hireDate, ModelMap model) {

		String message = String.format("DateOfBirth: %s<br> HireDate: %s", dateOfBirth, hireDate);
		model.addAttribute("message", message);

		return "displayRequestParam";
	}
	
//	@RequestMapping(value = "/ambiguous", method = RequestMethod.GET)
//	public String showEmployeeByName(@RequestParam(value = "name") String name, ModelMap model) {
//
//		model.addAttribute("message", "This is from showEmployeeByName() - " + name);
//
//		return "displayRequestParam";
//	}
//
//	@RequestMapping(value = "/ambiguous", method = RequestMethod.GET)
//	public String showEmployeeByAddress(@RequestParam(value = "address") String line, ModelMap model) {
//
//		model.addAttribute("message", "This is from showEmployeeByAddress() - " + line);
//
//		return "displayRequestParam";
//	}
	
	@RequestMapping(value = "/ambiguous", method = RequestMethod.GET, params = "name")
	public String showEmployeeByName(@RequestParam(value = "name") String name, ModelMap model) {

		model.addAttribute("message", "This is from showEmployeeByName() - " + name);

		return "displayRequestParam";
	}

	@RequestMapping(value = "/ambiguous", method = RequestMethod.GET, params = "address")
	public String showEmployeeByAddress(@RequestParam(value = "address") String line, ModelMap model) {

		model.addAttribute("message", "This is from showEmployeeByAddress() - " + line);

		return "displayRequestParam";
	}
}