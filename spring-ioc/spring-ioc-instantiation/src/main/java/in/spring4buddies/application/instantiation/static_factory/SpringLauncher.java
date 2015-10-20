package in.spring4buddies.application.instantiation.static_factory;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringLauncher {

	public static void main(String args[]) {

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext-annotation-component.xml");

		System.out.println("--------SpringLauncher-------------------");
		
		Address personalAddress = (PersonalAddress) applicationContext
				.getBean("springPersonalInstance");
		personalAddress.getAddress(null, null, null, null, null);

		Address workAddress = (WorkAddress) applicationContext
				.getBean("springWorkInstance");
		workAddress.getAddress(null, null, null, null, null);

		applicationContext.close();
	}
}
