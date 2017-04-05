package in.spring4buddies.application.controller;

import in.spring4buddies.application.domain.User;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@RequestMapping("/users")
	public String getAllUsers(Model model) {

		User user1 = new User();
		user1.setId("100");
		user1.setFirstName("Greg");
		user1.setLastName("Thomas");

		User user2 = new User();
		user2.setId("200");
		user2.setFirstName("Curt");
		user2.setLastName("McGennis");

		List<User> users = new ArrayList<>();
		users.add(user1);
		users.add(user2);

		model.addAttribute("users", users);
		
		return "users";
	}
}