package in.spring4buddies.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping({ "/user", "/client" })
@Controller
public class UserController {

	@RequestMapping(value = "/{name}/{email:.+}", method = { RequestMethod.GET, RequestMethod.DELETE })
	public String showUser(@PathVariable(value = "name") String name, @PathVariable(value = "email") String email, Model model) {

		model.addAttribute("msg", "Provided details are - <br> Name - " + name + "<br> Email - " + email);

		return "user";
	}
}