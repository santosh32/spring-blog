package in.spring4buddies.application;

import in.spring4buddies.application.constructor_injection.SpringFooBean;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringLauncher {

	public static void main(String args[]) {

		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext-annotation-component.xml");

		System.out.println("--------SpringLauncher-------------------");

		SpringFooBean springBean = (SpringFooBean) applicationContext
				.getBean("springBean");

		applicationContext.close();
	}
}
