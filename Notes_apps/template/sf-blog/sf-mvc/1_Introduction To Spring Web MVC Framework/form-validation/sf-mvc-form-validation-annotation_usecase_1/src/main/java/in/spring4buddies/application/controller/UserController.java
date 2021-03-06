package in.spring4buddies.application.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import in.spring4buddies.application.domain.User;

public class UserController extends SimpleFormController {

	public UserController() {
		setCommandClass(User.class);
		setCommandName("userForm");
	}

	@Override
	protected Object formBackingObject(HttpServletRequest request) throws Exception {
		User user = new User();
		user.setCountry("India");
		return user;
	}

	@Override
	protected Map<String, Object> referenceData(HttpServletRequest request) throws Exception {

		Map<String, Object> referenceData = new HashMap<>();

		List<String> communities = new ArrayList<>();
		communities.add("Spring");
		communities.add("Hibernate");
		communities.add("Struts");

		List<String> countries = new ArrayList<>();
		countries.add("Select");
		countries.add("India");
		countries.add("USA");
		countries.add("UK");

		List<String> hobbies = new ArrayList<String>();
		hobbies.add("Gardening");
		hobbies.add("Listening Music");
		hobbies.add("Writing Technical Tutorials");

		referenceData.put("communities", communities);
		referenceData.put("countries", countries);
		referenceData.put("hobbies", hobbies);

		return referenceData;

	}

	@Override
	protected ModelAndView onSubmit(Object command) throws Exception {
		User user = (User) command;
		return new ModelAndView("userSuccess", "user", user);
	}
}