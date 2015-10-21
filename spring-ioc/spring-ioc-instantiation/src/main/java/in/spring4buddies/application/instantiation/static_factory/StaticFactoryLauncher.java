package in.spring4buddies.application.instantiation.static_factory;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StaticFactoryLauncher {

	public static void main(String args[]) {

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext-annotation-component.xml");
		
		System.out.println("--------SpringLauncher-------------------");
		
		SpringStaticFactory springStaticFactory = (SpringStaticFactory) applicationContext
				.getBean("springStaticFactory");
		springStaticFactory.print();
		
		applicationContext.close();
	}
}
