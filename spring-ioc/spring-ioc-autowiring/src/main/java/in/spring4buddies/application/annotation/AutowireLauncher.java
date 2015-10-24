package in.spring4buddies.application.annotation;

import in.spring4buddies.application.autowiring.Address;
import in.spring4buddies.application.autowiring.Employee;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowireLauncher {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

		Employee employee = applicationContext.getBean("employee", Employee.class);
		Address address = applicationContext.getBean("address", Address.class);
		System.out.println("no wire - "+ employee.getAddress());
		
		Employee employee_byName = applicationContext.getBean("employee_byName", Employee.class);
		Address address_byName = applicationContext.getBean("address", Address.class);
		System.out.println("byName - "+ employee_byName.getAddress());
		
		Employee employee_byType = applicationContext.getBean("employee_byType", Employee.class);
		Address address_byType = applicationContext.getBean("address", Address.class);
		System.out.println("byType - "+ employee_byType.getAddress());
		
		Employee employee_constructor = applicationContext.getBean("employee_constructor", Employee.class);
		Address address_constructor = applicationContext.getBean("address", Address.class);
		System.out.println("constructor - "+ employee_constructor.getAddress());
		
		applicationContext.close();
	}
}
