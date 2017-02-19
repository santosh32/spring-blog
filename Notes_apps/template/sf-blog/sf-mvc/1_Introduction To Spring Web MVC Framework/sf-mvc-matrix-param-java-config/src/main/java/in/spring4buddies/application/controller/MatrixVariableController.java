package in.spring4buddies.application.controller;

import in.spring4buddies.application.command.Employee;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/{employee}")
public class MatrixVariableController {

	@RequestMapping(method = RequestMethod.GET)
	public String showEmployeeDetails(ModelMap model, @MatrixVariable Map<String, List<String>> matrixVars) {

		for(Map.Entry<String, List<String>> entry : matrixVars.entrySet()){
			System.out.println(entry.getKey() +" ==> "+entry.getValue());
		}
		Employee employee = new Employee();
//		employee.setName(matrixVars.get("name"));
//		employee.setAddress(matrixVars.get("address"));
//		employee.setCity(matrixVars.get("city"));
//		employee.setState(matrixVars.get("state"));
//		employee.setCountry(matrixVars.get("country"));

		model.addAttribute("employee", employee);
		return "employee";
	}

}