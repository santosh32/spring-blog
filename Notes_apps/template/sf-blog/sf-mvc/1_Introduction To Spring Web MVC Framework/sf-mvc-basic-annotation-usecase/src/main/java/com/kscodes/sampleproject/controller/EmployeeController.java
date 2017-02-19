package com.kscodes.sampleproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kscodes.sampleproject.model.Employee;

@Controller
public class EmployeeController {

	@RequestMapping("/employee")
	public ModelAndView getEmployee() {
		Employee employee = new Employee();
		ModelAndView mv = new ModelAndView("employee");
		mv.addObject("command", employee);
		return mv;
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public ModelAndView addEmployee(
			@ModelAttribute("employee") Employee employee) {

		// Save the Employee data in Database

		ModelAndView mv = new ModelAndView("success");
		mv.addObject("name",
				employee.getFirstName() + " " + employee.getLastName());

		return mv;

	}
}
