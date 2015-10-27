package in.spring4buddies.application;

import in.spring4buddies.application.lookup_method.SpringSingletonBean;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LookupMethodLauncher {

	public static void main(String args[]) {

		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext_lookup_method.xml");

		System.out.println("********* Observe output from Here ******");
		SpringSingletonBean springSingletonBean = applicationContext
				.getBean(SpringSingletonBean.class);
		
		for (int i = 0; i < 3; i++) {
			System.out.println("springSingletonBean - "
					+ springSingletonBean.call());
		}
		applicationContext.close();
	}
}
