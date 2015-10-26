package in.spring4buddies.application;

import in.spring4buddies.application.dependson.BeanA;
import in.spring4buddies.application.dependson.BeanB;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DependOnLauncher {

	public static void main(String args[]) {

		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		BeanA beanA = applicationContext.getBean("beanA", BeanA.class);
		BeanB beanB = applicationContext.getBean("beanB", BeanB.class);

		beanA.getBeanB().setName("BeanB");
		System.out.println(beanB.getName());

		applicationContext.close();
	}
}
