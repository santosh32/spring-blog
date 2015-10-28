package in.spring4buddies.application;

import in.spring4buddies.application.inheritance.Car;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InheritanceLauncher {

	public static void main(String args[]) {

		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext_inheritance.xml");

		Car car = applicationContext.getBean(Car.class);
		System.out.println("Car Speed is : "+car.getSpeed());

		applicationContext.close();
	}
}
