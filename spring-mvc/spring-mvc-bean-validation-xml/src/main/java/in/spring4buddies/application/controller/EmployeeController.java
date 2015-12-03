package in.spring4buddies.application.controller;

import in.spring4buddies.application.model.Employee;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class EmployeeController {

	@RequestMapping(method = RequestMethod.GET)
	public String newRegistration(ModelMap model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "enrollForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String saveRegistration(@Valid Employee employee,
			BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "enrollForm";
		}

		model.addAttribute("success", "Dear " + employee.getFirstName()
				+ " , your Registration completed successfully");
		return "enrollSuccess";
	}

}