package in.spring4buddies.application.instantiation.constructor;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringLauncher {

	public static void main(String args[]) {

		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext-annotation-component.xml");

		System.out.println("--------SpringLauncher-------------------");
		
		SpringBean springBean = (SpringBean) applicationContext
				.getBean("springBean");
		springBean.print();
		
		System.out.println("---------------------------");
		
		ConfigurableApplicationContext applicationContext2 = new ClassPathXmlApplicationContext(
				"applicationContext-annotation.xml");

		SpringBean springBean2 = (SpringBean) applicationContext2
				.getBean("springBean");
		springBean2.print();
		
		applicationContext.close();
		applicationContext2.close();
	}
}
