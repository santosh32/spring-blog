package in.spring4buddies.application.callback.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CallbackLauncher {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"beans-annotation.xml");

		Employee employee = applicationContext.getBean("employee",
				Employee.class);
		System.out.println(" " + employee);

		applicationContext.close();
	}
}
