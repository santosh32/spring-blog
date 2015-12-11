package in.spring4buddies.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class WelcomeController {
	
	@RequestMapping("welcome")
	public String hello(Model model) {
		System.out.println("Welcome Friends!");
		model.addAttribute("msg", "Welcome Friends!");
		return "welcome";
	}
}