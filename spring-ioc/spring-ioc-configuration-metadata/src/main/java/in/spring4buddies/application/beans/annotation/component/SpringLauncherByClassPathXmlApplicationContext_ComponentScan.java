package in.spring4buddies.application.beans.annotation.component;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringLauncherByClassPathXmlApplicationContext_ComponentScan {

	public static void main(String args[]) {

		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext-annotation-component.xml");

		SpringHelloWorldBean springHelloWorldApp = (SpringHelloWorldBean) applicationContext
				.getBean("springHelloWorldBean");
		springHelloWorldApp.print();

		SpringFooBean springFooBean = (SpringFooBean) applicationContext
				.getBean("springFooBean");
		springFooBean.foo();
	}
}
