package in.spring4buddies.application.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@RequestMapping("/add.htm")
	public ModelAndView testaddEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("EmployeePage", "msg", "EmployeeController.testaddEmployee() method");
	}

	@RequestMapping("/delete.htm")
	public ModelAndView testdeleteEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("EmployeePage", "msg", "EmployeeController.testdeleteEmployee() method");
	}

	@RequestMapping("/update.htm")
	public ModelAndView testupdateEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("EmployeePage", "msg", "EmployeeController.testupdateEmployee() method");
	}

	@RequestMapping("/list.htm")
	public ModelAndView testlistEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("EmployeePage", "msg", "EmployeeController.testlistEmployee() method");
	}
}