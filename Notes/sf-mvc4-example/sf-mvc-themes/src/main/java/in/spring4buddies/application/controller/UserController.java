package in.spring4buddies.application.controller;

import in.spring4buddies.application.bean.User;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ModelAndView user(Locale locale) {
		return new ModelAndView("userform", "user", new User());
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("user") User user) {
		return "success";
	}
}