package in.spring4buddies.application.controller;

import in.spring4buddies.application.model.Employee;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public String newEmployee() {
		return "employee";
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public @ResponseBody ModelAndView addEmployee(BindingResult bindingResult, @RequestBody Employee employee) {

		ModelAndView mv = new ModelAndView("success");
		mv.addObject("name", employee.getFirstName() + " " + employee.getLastName());

		return mv;
	}
}
