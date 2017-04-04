package in.spring4buddies.application.controller;

import in.spring4buddies.application.domain.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@RequestMapping("/userForm")
	public String newUser(Model model) {
		User user1 = new User();
		User user1 = new User();
		User user1 = new User();
		
		model.addAttribute("users", user);
		return "userForm";
	}

}