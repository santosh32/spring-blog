package in.spring4buddies.application.beans.annotation;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringLauncherByClassPathXmlApplicationContext {

	public static void main(String args[]) {

		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext-annotation.xml");

		SpringHelloWorldBean springHelloWorldApp = (SpringHelloWorldBean) applicationContext
				.getBean("springHelloWorldBean");
		springHelloWorldApp.print();

		SpringFooBean springFooBean = (SpringFooBean) applicationContext
				.getBean("springFooBean");
		springFooBean.foo();
	}
}
