package in.spring4buddies.application;

import in.spring4buddies.application.method_replacer.SpringFooBean;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MethodReplacerLauncher {

	public static void main(String args[]) {

		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext_method_replacer.xml");

		System.out.println("********* Observe output from Here ******");
		SpringFooBean springFooBean = applicationContext
				.getBean(SpringFooBean.class);
		System.out.println(springFooBean.getMessage());

		applicationContext.close();
	}
}
