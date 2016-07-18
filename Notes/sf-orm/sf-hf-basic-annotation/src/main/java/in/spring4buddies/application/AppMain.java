package in.spring4buddies.application;

import in.spring4buddies.application.config.ApplicationConfig;
import in.spring4buddies.application.model.Employee;
import in.spring4buddies.application.service.EmployeeService;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.LocalDate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class AppMain {

	public static void main(String args[]) {

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		EmployeeService service = (EmployeeService) context.getBean("employeeService");

		Employee employee1 = new Employee();
		employee1.setName("Han Yenn");
		employee1.setJoiningDate(new LocalDate(2010, 10, 10));
		employee1.setSalary(new BigDecimal(10000));
		employee1.setSsn("ssn00000001");

		Employee employee2 = new Employee();
		employee2.setName("Dan Thomas");
		employee2.setJoiningDate(new LocalDate(2012, 11, 11));
		employee2.setSalary(new BigDecimal(20000));
		employee2.setSsn("ssn00000002");

		System.out.println(" ****** Saving emplyee 1 to the database ****** ");
		service.saveEmployee(employee1);
		System.out.println(" ****** Saving emplyee 2 to the database ****** ");
		service.saveEmployee(employee2);

		System.out.println(" ****** find all emplyees from database ****** ");
		List<Employee> employees = service.findAllEmployees();
		for (Employee emp : employees) {
			System.out.println(emp);
		}

		System.out.println(" ****** delete emplyee 2 from database ****** ");
		service.deleteEmployeeBySsn("ssn00000002");

		System.out.println(" ****** update emplyee 1 to database ****** ");
		Employee employee = service.findBySsn("ssn00000001");
		employee.setSalary(new BigDecimal(50000));
		service.updateEmployee(employee);

		System.out.println(" ****** find all emplyees from database ****** ");
		List<Employee> employeeList = service.findAllEmployees();
		for (Employee emp : employeeList) {
			System.out.println(emp);
		}

		context.close();
	}
}
