package in.spring4buddies.application.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class EmployeeController extends MultiActionController {

	public ModelAndView testaddEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("EmployeePage", "msg", "EmployeeController.testaddEmployee() method");
	}

	public ModelAndView testdeleteEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("EmployeePage", "msg", "EmployeeController.testdeleteEmployee() method");
	}

	public ModelAndView testupdateEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("EmployeePage", "msg", "EmployeeController.testupdateEmployee() method");
	}

	public ModelAndView testlistEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("EmployeePage", "msg", "EmployeeController.testlistEmployee() method");
	}
}