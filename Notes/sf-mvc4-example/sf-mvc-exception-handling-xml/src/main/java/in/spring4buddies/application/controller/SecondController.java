package in.spring4buddies.application.controller;

import in.spring4buddies.application.exception.CustomException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecondController {

	@RequestMapping(value = "/second", method = RequestMethod.GET)
	public ModelAndView second() throws CustomException {
		System.out.println("Throwing exception");
		throw new CustomException("This is a message from second controller");
	}

	@ExceptionHandler(CustomException.class)
	public ModelAndView handleCustomException(CustomException ex) {
		System.out.println("Handling exception");
		ModelAndView model = new ModelAndView("error");
		model.addObject("exception", ex);
		return model;
	}
}