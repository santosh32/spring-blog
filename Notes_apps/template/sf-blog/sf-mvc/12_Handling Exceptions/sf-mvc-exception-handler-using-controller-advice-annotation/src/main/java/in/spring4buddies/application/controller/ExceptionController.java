package in.spring4buddies.application.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(IOException.class)
	public ModelAndView processException(IOException ioe) {
		
		ModelAndView mav = new ModelAndView("exceptionPage");
		mav.addObject("name", ioe.getClass().getSimpleName());
		mav.addObject("message", ioe.getMessage());

		return mav;
	}
}