package in.spring4buddies.application.annotation;

import in.spring4buddies.application.scope.annotation.SpringPrototype;
import in.spring4buddies.application.scope.annotation.SpringSingleton;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringLauncher {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans-annotation.xml");

		SpringSingleton springScope = (SpringSingleton) context.getBean("springSingleton");
		springScope.setMessage("SpringSingleton -> Singleton");
		springScope.getMessage();

		SpringSingleton springScope1 = (SpringSingleton) context.getBean("springSingleton");
		springScope1.getMessage();
		
		System.out.println("--------------------");
		
		
		SpringPrototype springPrototype = (SpringPrototype) context.getBean("springPrototype");
		springPrototype.setMessage("SpringPrototype -> Prototype");
		springPrototype.getMessage();

		SpringPrototype springPrototype1 = (SpringPrototype) context.getBean("springPrototype");
		springPrototype1.getMessage();
		System.out.println("--------------------");
	}
}
