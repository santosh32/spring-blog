package in.spring4buddies.application.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.spring4buddies.application.command.Address;
import in.spring4buddies.application.service.AddressService;

@Controller
@RequestMapping("/address")
public class AddressController {

	@Resource(name = "addressService")
	private AddressService addressService;

	@ModelAttribute("addresses")
	public List<Address> getAllAddresses() {
		return addressService.getAll();
	}

	@RequestMapping(value = "list1", method = RequestMethod.GET)
	public String getAllUsingModelAttribute() {

		// No need to add the model here
		// It has been automatically added when we used the @ModelAttribute annotation earlier
		// The name of the ModelAttribute is "addresses". Your JSP should reference "addresses"

		// This will resolve to /WEB-INF/views/addressespage.jsp
		return "addressespage";
	}

	@RequestMapping(value = "list2", method = RequestMethod.GET)
	public String getAllUsingModel(Model model) {

		// Here we add the model manually
		// This should give the same result with the extra greetings
		// The name of the Model is "addresses". Your JSP should reference "addresses" as well
		// will work with out this .
		model.addAttribute("addresses", addressService.getAll());
		model.addAttribute("greetings", "I came from Model not ModelAttribute");

		// This will resolve to /WEB-INF/views/addressespage.jsp
		return "addressespage";
	}

}
