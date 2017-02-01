package in.spring4buddies.application;

import in.spring4buddies.application.dao.EmployeeDao;
import in.spring4buddies.application.model.Employee;
import in.spring4buddies.application.service.EmployeeService;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) throws Exception {
		String confFile = "beans.xml";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(confFile);

		EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");

		System.out.println(" *****  Insert new employee ******");
		Employee newEmployee = new Employee();
		newEmployee.setEmpId(1);
		newEmployee.setDept("DB");
		newEmployee.setName("Garav");
		newEmployee.setSalary(1000);
		employeeService.insertEmployee(newEmployee);

		System.out.println(" *****  Select employee by id ******");
		Employee employee = employeeService.findEmployeeById(1);
		System.out.println(employee.getName() + " | " + employee.getSalary() + " | " + employee.getDept());

		System.out.println(" *****  Update employee ******");
		Employee updateEmployee = new Employee();
		updateEmployee.setEmpId(1);
		updateEmployee.setSalary(2000);
		employeeService.updateEmployee(updateEmployee);

		System.out.println(" *****  Select employee by id ******");
		employee = employeeService.findEmployeeById(1);
		System.out.println(employee.getName() + " | " + employee.getSalary() + " | " + employee.getDept());

		System.out.println(" *****  Delete employee ******");
		employeeService.removeEmployee(1);

		System.out.println(" *****  Select employee by id ******");
		try {
			employee = employeeService.findEmployeeById(1);
			System.out.println(employee.getName() + " | " + employee.getSalary() + " | " + employee.getDept());
		} catch (Exception e) {
			System.out.println("No Records found ? ");
		}

		context.close();
	}
}
