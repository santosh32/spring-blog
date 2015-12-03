package in.spring4buddies.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class CustomHiController {

	@RequestMapping(method = RequestMethod.GET)
	public String sayHi(ModelMap model) {
		model.addAttribute("greeting", "Hi from Spring 4 MVC with config");
		return "welcome";
	}

	@RequestMapping(value = "/hiagain", method = RequestMethod.GET)
	public String sayHiAgain(ModelMap model) {
		model.addAttribute("greeting", "Hi Again, from Spring 4 MVC with config");
		return "welcome";
	}

}