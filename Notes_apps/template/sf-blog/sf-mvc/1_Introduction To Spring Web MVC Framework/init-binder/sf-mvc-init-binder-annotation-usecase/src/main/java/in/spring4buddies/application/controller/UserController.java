package in.spring4buddies.application.controller;

import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.number.CurrencyStyleFormatter;
import org.springframework.format.number.NumberStyleFormatter;
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

		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		dateFormatter.setLenient(false);
		binder.registerCustomEditor(Date.class, "dateOfBirth", new CustomDateEditor(dateFormatter, true));

		DateFormatter dateFormatter1 = new DateFormatter();
		dateFormatter1.setPattern("MM-dd-yyyy");
		binder.addCustomFormatter(dateFormatter1, "dateOfBirth");

		NumberStyleFormatter numberFormatter = new NumberStyleFormatter();
		numberFormatter.setPattern("#,###,###,###.##");
		binder.addCustomFormatter(numberFormatter, "salary");

		CurrencyStyleFormatter currencyFormatter = new CurrencyStyleFormatter();
		currencyFormatter.setCurrency(Currency.getInstance("USD"));
		binder.addCustomFormatter(currencyFormatter, "salary");
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