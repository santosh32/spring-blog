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
		System.out.println("springFooBean - "+springFooBean.toString());
		
		SpringFooBean springFooBean1 = (SpringFooBean) applicationContext
				.getBean("springFooBean1");
		System.out.println("springFooBean1 - " + springFooBean1.toString());
		
		SpringFooBean springFooBean2 = (SpringFooBean) applicationContext
				.getBean("springFooBean2");
		System.out.println("springFooBean2 - "+springFooBean2.toString());
		
		SpringFooBean springFooBean3 = (SpringFooBean) applicationContext
				.getBean("springFooBean3");
		System.out.println("springFooBean3 - "+springFooBean3.toString());

		applicationContext.close();
	}
}
