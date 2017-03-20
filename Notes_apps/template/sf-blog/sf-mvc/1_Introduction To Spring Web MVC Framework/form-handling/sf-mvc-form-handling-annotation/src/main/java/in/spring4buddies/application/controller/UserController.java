package in.spring4buddies.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.spring4buddies.application.domain.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(method = RequestMethod.GET)
	public String handleGetRequest() {
		return "userForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String handlePostRequest(User user, Model model) {
		return "userSuccess";
	}
}