package in.spring4buddies.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/person")
public class PersonController {
	
	@RequestMapping("/welcome")
	public String hello(Model model) {
		System.out.println("Welcome Friends!");
		model.addAttribute("msg", "Welcome Friends!");
		return "result";
	}

	@RequestMapping("/save/info")
	public String savePerson(@RequestParam(value = "name") String name,
			Model model) {
		System.out.println("Person Saved, name:" + name);
		model.addAttribute("msg", "Request Processed");
		return "result";
	}
}
