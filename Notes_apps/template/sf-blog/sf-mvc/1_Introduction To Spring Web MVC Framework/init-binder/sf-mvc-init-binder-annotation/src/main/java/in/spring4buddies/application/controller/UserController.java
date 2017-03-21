package in.spring4buddies.application.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import in.spring4buddies.application.command.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@InitBinder
	public void customizeBinding(WebDataBinder binder) {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		dateFormatter.setLenient(false);
		binder.registerCustomEditor(Date.class, "dateOfBirth", new CustomDateEditor(dateFormatter, true));
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView get() {

		ModelAndView modelAndView = new ModelAndView("userForm");
		// Step 1.
		modelAndView.addObject("command", new User());
		// Step 2 & 3.
		modelAndView.addObject("user", new User());
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String post(User user, BindingResult bindingResult, Model model) {
		
		System.out.println(user);
		return "userSuccess";
	}
}