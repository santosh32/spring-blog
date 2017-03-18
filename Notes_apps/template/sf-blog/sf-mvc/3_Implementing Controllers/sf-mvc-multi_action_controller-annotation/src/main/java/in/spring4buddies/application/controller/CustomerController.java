package in.spring4buddies.application.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@RequestMapping("/add.htm")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("CustomerPage", "msg", "CustomerController.add() method");
	}

	@RequestMapping("/delete.htm")
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("CustomerPage", "msg", "CustomerController.delete() method");
	}

	@RequestMapping("/update.htm")
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("CustomerPage", "msg", "CustomerController.update() method");
	}

	@RequestMapping("/list.htm")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("CustomerPage", "msg", "CustomerController.list() method");
	}
}