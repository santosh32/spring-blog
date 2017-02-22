package in.spring4buddies.application.controller;

import in.spring4buddies.application.command.Employee;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping({ "/user", "/client" })
@Controller
public class UserController {

	@RequestMapping(value = "/{name}/{email:.+}", method = { RequestMethod.GET, RequestMethod.DELETE })
	public String showUserByEmail(@PathVariable(value = "name") String name, @PathVariable(value = "email") String email, Model model) {

		model.addAttribute("msg", "Provided details are - <br> Name - " + name + "<br> Email - " + email);

		return "user";
	}

	@RequestMapping(value = "/{userId:[0-9]+}", method = { RequestMethod.GET, RequestMethod.DELETE })
	public String showUserById(@PathVariable(value = "userId") int userId, Model model) {

		model.addAttribute("msg", "Provided details are - <br> userId - " + userId);

		return "user";
	}

	@RequestMapping(value = "/{name}", params = { "state=TS", "country=IN" })
	public String displayUserWithParams(@PathVariable(value = "name") String name, Model model) {

		model.addAttribute("msg", "Provided details are - params info state=TS, country=IN <br> name - " + name);

		return "user";
	}

	@RequestMapping(value = "/{name}", headers = { "address=GreenLine" })
	public String displayUserWithHeaders(@PathVariable(value = "name") String name, Model model) {

		model.addAttribute("msg", "Provided details are - headers info address=GreenLine <br> name - " + name);

		return "user";
	}

	@RequestMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Employee displayUserAsJson() {
		return new Employee(1000, "Greg Manohan", "Green Ville", "greg.manohan@gmail.com", "East Mountain", "TX", "US");
	}

	@RequestMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
	public @ResponseBody Employee displayUserAsXml() {
		return new Employee(1000, "Greg Manohan", "Green Ville", "greg.manohan@gmail.com", "East Mountain", "TX", "US");
	}

	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public Employee consumeUserJson(@RequestBody Employee employee) {
		return employee;
	}

	@RequestMapping(consumes = MediaType.APPLICATION_XML_VALUE)
	public Employee consumeUserXml(@RequestBody Employee employee, Model model) {

		return employee;
	}

}