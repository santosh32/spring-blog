package in.spring4buddies.application.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import in.spring4buddies.application.exception.CustomException;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(IOException.class)
	public ModelAndView processException(IOException ioe) {

		ModelAndView mav = new ModelAndView("exceptionPage");
		mav.addObject("name", ioe.getClass().getSimpleName());
		mav.addObject("message", ioe.getMessage());

		return mav;
	}

	@ExceptionHandler(CustomException.class)
	public ModelAndView processCustomException(CustomException ce) {

		ModelAndView mav = new ModelAndView("exceptionPage");
		mav.addObject("name", ce.getName());
		mav.addObject("message", ce.getMessage());

		return mav;
	}
}