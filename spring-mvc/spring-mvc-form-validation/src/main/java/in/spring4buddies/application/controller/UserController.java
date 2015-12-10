package in.spring4buddies.application.controller;

import in.spring4buddies.application.model.User;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class UserController {

	@RequestMapping(value="user", method = RequestMethod.GET)
	public User user(){
		return new User(); 
	}

	@RequestMapping(value = "createUser", method = RequestMethod.POST)
	public String createUser(@ModelAttribute("user") @Valid User user,
			BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "user";
		}

		model.addAttribute("name", user.getName());
		model.addAttribute("age", user.getAge());
		model.addAttribute("location", user.getLocation());

		return "userSuccess";

	}
}
