package in.spring4buddies.application.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class CustomerController extends MultiActionController {

	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("CustomerPage", "msg", "CustomerController.add() method");
	}

	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("CustomerPage", "msg", "CustomerController.delete() method");
	}

	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("CustomerPage", "msg", "CustomerController.update() method");
	}

	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("CustomerPage", "msg", "CustomerController.list() method");
	}
}