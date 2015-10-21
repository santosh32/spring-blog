package in.spring4buddies.application;

import in.spring4buddies.application.c_namespace.SpringFooBean;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringLauncher {

	public static void main(String args[]) {

		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext_c_namespace.xml");

		System.out.println("-------- SpringLauncher -------------------");

		SpringFooBean springFooBean = (SpringFooBean) applicationContext
				.getBean("springFooBean");
		System.out.println("springFooBean - "+springFooBean.toString());
		
		System.out.println("---------------------------");
		
		ConfigurableApplicationContext applicationContext1 = new ClassPathXmlApplicationContext(
				"applicationContext_p_namespace.xml");

		System.out.println("-------- SpringLauncher -------------------");

		in.spring4buddies.application.p_namespace.SpringFooBean springFooBeanp = (in.spring4buddies.application.p_namespace.SpringFooBean) applicationContext1
				.getBean("springFooBean");
		System.out.println("springFooBeanp \n "+springFooBeanp.toString());
		

		applicationContext.close();
		applicationContext1.close();
	}
}
