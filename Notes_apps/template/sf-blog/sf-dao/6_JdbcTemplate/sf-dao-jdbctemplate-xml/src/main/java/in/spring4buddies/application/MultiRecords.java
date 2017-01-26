package in.spring4buddies.application;

import in.spring4buddies.application.dao.EmployeeDao;
import in.spring4buddies.application.model.Employee;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MultiRecords {

	public static void main(String[] args) throws Exception {
		String confFile = "beans.xml";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(confFile);

		EmployeeDao empDao = (EmployeeDao) context.getBean("employeeDao");

		System.out.println(" *****  Insert new employees ******");
		for (int i = 1; i <= 10; i++) {
			Employee newEmployee = new Employee();
			newEmployee.setEmpId(i);
			newEmployee.setDept("DB " + i);
			newEmployee.setName("Garav " + i);
			newEmployee.setSalary(1000 + i);
			System.out.println(" *****  Insert new employee ****** " + i);
			empDao.insertEmployee(newEmployee);
		}

		System.out.println(" *****  Select employees ******");
		List<Employee> employees = empDao.findAll();
		for (Employee employee : employees) {
			System.out.println(employee.getName() + " | " + employee.getName() + " | " + employee.getSalary() + " | " + employee.getDept());
		}

		context.close();
	}
}
