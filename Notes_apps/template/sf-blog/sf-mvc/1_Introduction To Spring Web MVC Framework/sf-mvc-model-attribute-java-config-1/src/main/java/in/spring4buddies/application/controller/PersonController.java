package in.spring4buddies.application.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import in.spring4buddies.application.command.Person;
import in.spring4buddies.application.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {

	@Resource(name = "personService")
	private PersonService personService;

	@ModelAttribute("persons")
	public List<Person> getAllPersons() {
		return personService.getAll();
	}

	@ModelAttribute("currencies")
	public List<String> getAllCurrencies() {
		List<String> currencies = new ArrayList<String>();
		currencies.add("Dollar");
		currencies.add("Yen");
		currencies.add("Pound");
		currencies.add("Euro");
		currencies.add("Dinar");
		return currencies;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView country() {
		return new ModelAndView("person", "person", new Person());
	}

	@RequestMapping(method = RequestMethod.POST)
	public String save(@ModelAttribute("person") Person person, Model model) {

		model.addAttribute("persons", person);

		return "displayPersons";
	}
}
