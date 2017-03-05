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

		// The personspage.jsp referecences a model attribute named "persons"  We don't need to add the model here manually
		// It has been automatically added when we used @ModelAttribute("persons") earlier

		// This will resolve to /WEB-INF/views/personspage.jsp
		return "personspage";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String getEdit(@PathVariable Integer id, Model model) {

		// Retrieve person with matching id then add this person to the model
		// The editpage.jsp references a model attribute named "personAttribute"
		// So we add a "personAttribute" to the model.
		// This "personAttribute" will be referenced again once we send the
		// update form data
		// We could have chosen a different name like "person" for the model
		// If you do, make sure you update the JSP that references this name
		// And update the POST method below that receives the request to do the
		// actual update!
		model.addAttribute("personAttribute", personService.get(id));

		// The editpage.jsp references a model attribute named "currencies"
		// This model attribute is passed automatically when used
		// @ModelAttribute("currencies") earlier

		// This will resolve to /WEB-INF/views/editpage.jsp
		return "editpage";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String saveEdit(@ModelAttribute("personAttribute") Person person, @PathVariable Integer id, Model model) {

		// The "personAttribute" model has been passed to the controller from
		// the JSP
		// We use the name "personAttribute" because the JSP uses that name

		// We manually assign the id because we disabled it in the JSP page
		// When a field is disabled it will not be included in the
		// ModelAttribute
		person.setId(id);

		// Delegate to PersonService for editing
		// We show the all persons page again after updating the person
		personService.edit(person);

		// The personspage.jsp referecences a model attribute named "persons"
		// We don't need to add the model here manually
		// It has been automatically added when we used
		// @ModelAttribute("persons") earlier

		// However there's are two problems:

		// 1. The @ModelAttribute("persons") is called first before the actual
		// update is performed.
		// When the personspage is returned, the list of persons BEFORE
		// the update is the list that will be retrieved.
		// You will need to refresh the browser again to see the new list

		// 2. You can try redirecting but you'll hit a known bug
		// See
		// http://stackoverflow.com/questions/2163517/how-do-i-prevent-spring-3-0-mvc-modelattribute-variables-from-appearing-in-url

		// To avoid all that hassles, we just add the updated list of persons to
		// the Model
		// The "persons" attribute here is not the same with
		// @ModelAttribute("persons")
		// However, your JSP page references the same name so it won't care
		model.addAttribute("persons", personService.getAll());

		// This will resolve to /WEB-INF/views/personspage.jsp
		return "personspage";
	}
}
