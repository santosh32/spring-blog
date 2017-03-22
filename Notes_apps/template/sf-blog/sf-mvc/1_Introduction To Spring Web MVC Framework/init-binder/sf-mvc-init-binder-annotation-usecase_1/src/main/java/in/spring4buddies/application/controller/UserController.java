package in.spring4buddies.application.controller;

import java.util.Currency;
import java.util.Locale;

import org.springframework.format.number.CurrencyStyleFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import in.spring4buddies.application.command.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@InitBinder
	public void customizeBinding(WebDataBinder binder) {
		// CurrencyStyleFormatter currencyFormatter = new
		// CurrencyStyleFormatter();
		// currencyFormatter.setCurrency(Currency.getInstance(Locale.US));
		// binder.addCustomFormatter(currencyFormatter, "amount");
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView get() {
		ModelAndView modelAndView = new ModelAndView("userForm");
		modelAndView.addObject("user", new User());
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String post(User user, BindingResult bindingResult, Model model) {
		System.out.println(user);
		return "userSuccess";
	}
}