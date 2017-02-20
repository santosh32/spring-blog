package in.spring4buddies.application.controller;

import in.spring4buddies.application.model.Employee;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public ModelAndView newEmployee() {
		ModelAndView mv = new ModelAndView("employee");
		mv.addObject("command", new Employee());
		return mv;
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public ModelAndView addEmployee(@ModelAttribute("employee") Employee employee) {

		// Save the Employee data in Database

		ModelAndView mv = new ModelAndView("success");
		mv.addObject("name", employee.getFirstName() + " " + employee.getLastName());

		return mv;

	}
}
