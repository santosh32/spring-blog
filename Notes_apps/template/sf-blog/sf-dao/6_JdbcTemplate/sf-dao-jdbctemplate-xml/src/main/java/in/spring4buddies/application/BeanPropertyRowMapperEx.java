package in.spring4buddies.application;

import in.spring4buddies.application.dao.EmployeeDao;
import in.spring4buddies.application.model.Employee;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanPropertyRowMapperEx {

	public static void main(String[] args) throws Exception {
		String confFile = "beans.xml";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(confFile);

		EmployeeDao empDao = (EmployeeDao) context.getBean("employeeDao");

		System.out.println(" *****  Select employees ******");
		List<Employee> employees = empDao.findAll();
		for (Employee employee : employees) {
			System.out.println(employee.getName() + " | " + employee.getName() + " | " + employee.getSalary() + " | " + employee.getDept());
		}

		context.close();
	}
}
