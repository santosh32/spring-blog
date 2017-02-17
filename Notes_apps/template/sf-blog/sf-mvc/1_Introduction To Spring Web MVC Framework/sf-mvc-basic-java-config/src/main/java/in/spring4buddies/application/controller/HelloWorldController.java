package in.spring4buddies.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HelloWorldController {

	@RequestMapping(method = RequestMethod.GET)
	public String sayHello(ModelMap model) {
		System.out.println("");
		model.addAttribute("greeting", "Hello World from Spring MVC Config");
		return "welcome";
	}

	@RequestMapping(value = "/helloagain", method = RequestMethod.GET)
	public String sayHelloAgain(ModelMap model, @RequestParam(value = "name", defaultValue = "Guest") String name) {
		model.addAttribute("greeting", "Hello " + name + ", <br>This Response Spring MVC using MVCConfig");
		return "welcome";
	}

}