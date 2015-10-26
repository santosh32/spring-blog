package in.spring4buddies.application.callback;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CallbackLauncher {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"beans.xml");

		Employee employee = applicationContext.getBean("employee",
				Employee.class);
		System.out.println(" " + employee);

		EmployeeWithInferface employeeWithInferface = applicationContext
				.getBean("employeeWithInferface", EmployeeWithInferface.class);
		System.out.println(" " + employeeWithInferface);

		applicationContext.close();
	}
}
