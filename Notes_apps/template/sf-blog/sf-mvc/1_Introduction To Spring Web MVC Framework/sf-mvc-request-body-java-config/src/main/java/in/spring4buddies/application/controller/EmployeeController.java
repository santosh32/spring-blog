package in.spring4buddies.application.controller;

import in.spring4buddies.application.model.Employee;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public ModelAndView newEmployee() {
		return new ModelAndView("employee", "command", new Employee());
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public @ResponseBody ModelAndView addEmployee(@RequestBody Employee employee) {

		ModelAndView mv = new ModelAndView("success");
		mv.addObject("name", employee.getFirstName() + " " + employee.getLastName());

		return mv;
	}
}
