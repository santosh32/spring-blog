package in.spring4buddies.application.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import in.spring4buddies.application.domain.User;

@Controller
public class UserController {

	@ModelAttribute("countries")
	public List<String> getCountries() {
		List<String> countries = new ArrayList<>();
		countries.add("Select");
		countries.add("India");
		countries.add("USA");
		countries.add("UK");
		return countries;
	}

	@ModelAttribute("communities")
	public List<String> getCommunities() {
		List<String> communities = new ArrayList<>();
		communities.add("Spring");
		communities.add("Hibernate");
		communities.add("Struts");
		return communities;
	}

	@RequestMapping("/userForm")
	public String newUser(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "userForm";
	}

	@RequestMapping(value = "/userForm", method = RequestMethod.POST)
	public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult result) throws Exception {
		if (result.hasErrors()) {
			System.out.println(result);
			return "userForm";
		}
		if (user.getName().length() > 6) {
			throw new IOException("Forcely thrown exception!!!");
		}
		return "userSuccess";
	}

	@ExceptionHandler(IOException.class)
	public ModelAndView processException(IOException ioe) {

		ModelAndView mav = new ModelAndView("exceptionPage");
		mav.addObject("name", ioe.getClass().getSimpleName());
		mav.addObject("message", ioe.getMessage());

		return mav;
	}
}