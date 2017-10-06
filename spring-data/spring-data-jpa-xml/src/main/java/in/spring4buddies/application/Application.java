package in.spring4buddies.application;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.spring4buddies.application.model.Employee;
import in.spring4buddies.application.service.EmployeeService;

public class Application {

	public static void main(String[] args) {

		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
//		EmployeeService service = context.getBean(EmployeeService.class);
//
//		Employee employee = new Employee(1000, "Sam", "Fox", "Imaginea");
//		service.save(employee);

		context.close();
	}
}
