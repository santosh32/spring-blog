package in.spring4buddies.application.controller;

import in.spring4buddies.application.bean.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class UserController {

//	@RequestMapping(value = "user", method = RequestMethod.GET)
//	public ModelAndView user(Locale locale) {
//		return new ModelAndView("user", "user", new User());
//	}
	@RequestMapping(value = "user", method = RequestMethod.GET)
	public ModelAndView user() {
		return new ModelAndView("user", "user", new User());
	}

	@RequestMapping(value = "save", method = RequestMethod.GET)
	public String save(/*@ModelAttribute("user") User user*/) {
		return "success";
	}
}