package in.spring4buddies.application.jpa.web;

import in.spring4buddies.application.jpa.domain.Employee;
import in.spring4buddies.application.jpa.repository.EmployeeRepository;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
@Transactional
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		Iterator<Employee> employees = employeeRepository.findAll().iterator();
		return IteratorUtils.toList(employees);
	}

	@PostMapping("/employees")
	public void saveEmployee(@RequestBody String json) {
		Gson gson = new Gson();
		Employee employee = gson.fromJson(json, Employee.class);  
		employeeRepository.save(employee);
	}
	//{"name":"santosh","salary":10000.0,"address":{"addressLine1":"Gayathri Classic","zipcode":"508218","city":"HYD"}}
}
