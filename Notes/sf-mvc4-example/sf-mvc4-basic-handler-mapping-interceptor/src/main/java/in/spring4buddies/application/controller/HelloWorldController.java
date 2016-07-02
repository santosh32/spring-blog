package in.spring4buddies.application.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class HelloWorldController extends AbstractController {

	private static final Logger logger = Logger
			.getLogger(HelloWorldController.class);

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ModelAndView model = new ModelAndView("helloWorld");
		model.addObject("msg", "hello world!");
		logger.info("Hello World Controller is invoked! ");
		return model;
	}
}