package in.spring4buddies.application.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String getAllPage(Model model) {

		return "personspage";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String getEdit(@PathVariable Integer id, Model model) {

		model.addAttribute("personAttribute", personService.get(id));

		return "editpage";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String saveEdit(@ModelAttribute("personAttribute") Person person, @PathVariable Integer id, Model model) {

		person.setId(id);

		personService.edit(person);

		model.addAttribute("persons", personService.getAll());

		return "personspage";
	}
}
