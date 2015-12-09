package in.spring4buddies.application.controller;

import in.spring4buddies.application.model.User;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class LoginController {

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "userCheck", method = RequestMethod.POST)
	public String userCheck(ModelMap model, HttpServletRequest request) {

		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String nextPage = "login";

		if ("admin".equalsIgnoreCase(name) && "password".equalsIgnoreCase(pwd)) {
			model.addAttribute("command", new User());
			nextPage = "user";
		} else {
			model.addAttribute("message", "Username or password is wrong.");
			nextPage = "invalidCredential";
		}
		return nextPage;
	}
}