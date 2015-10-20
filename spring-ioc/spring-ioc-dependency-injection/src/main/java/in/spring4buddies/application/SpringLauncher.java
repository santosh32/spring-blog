package in.spring4buddies.application;

import in.spring4buddies.application.constructor_injection.SpringFooBean;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringLauncher {

	public static void main(String args[]) {

		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		System.out.println("--------SpringLauncher-------------------");

		SpringFooBean springFooBean = (SpringFooBean) applicationContext
				.getBean("springFooBean");
		System.out.println(springFooBean.toString());

		applicationContext.close();
	}
}
