package in.spring4buddies.application.controller;

import in.spring4buddies.application.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class UserController {
	
	@RequestMapping(value = "user", method = RequestMethod.GET)
	public ModelAndView user() {
		return new ModelAndView("user", "command", new User());
	}

	@RequestMapping(value = "createUser", method = RequestMethod.POST)
	public String createUser(@ModelAttribute("user") User user, ModelMap model) {
		
		model.addAttribute("name", user.getName());
		model.addAttribute("age", user.getAge());
		model.addAttribute("location", user.getLocation());
		
		return "userSuccess";
	}
}
