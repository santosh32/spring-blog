package in.spring4buddies.application.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import in.spring4buddies.application.domain.User;

public class UserController extends SimpleFormController {

	public UserController() {
		setCommandClass(User.class);
		setCommandName("userForm");
	}

	@Override
	protected ModelAndView onSubmit(Object command) throws Exception {
		User user = (User) command;
		return new ModelAndView("userSuccess", "user", user);
	}
}