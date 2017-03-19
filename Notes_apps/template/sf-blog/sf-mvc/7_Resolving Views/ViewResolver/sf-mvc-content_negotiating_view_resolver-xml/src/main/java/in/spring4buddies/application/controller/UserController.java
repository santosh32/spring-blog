package in.spring4buddies.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import in.spring4buddies.application.domain.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value = "{name}", method = RequestMethod.GET)
	protected ModelAndView get(@PathVariable String name) throws Exception {

		User user = new User();
		user.setName(name);
		user.setAboutYou("Nothing to say");
		user.setCommunity(new String[] { "Spring Boot", "Spring Security" });
		user.setCountry("IN");
		user.setFeed(true);
		user.setGender("M");

		return new ModelAndView("userPage", "user", user);
	}
}