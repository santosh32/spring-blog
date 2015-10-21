package in.spring4buddies.application;

import in.spring4buddies.application.beans.CollectionBean;
import in.spring4buddies.application.beans.SpringFooBean;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringLauncher {

	public static void main(String args[]) {

		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		System.out.println("-------- SpringLauncher -------------------");

		CollectionBean collectionBean = (CollectionBean) applicationContext
				.getBean("collectionBean");
		System.out.println("list - " + collectionBean.getSomeList());
		System.out.println("set - " + collectionBean.getSomeSet());
		System.out.println("Map - " + collectionBean.getSomeMap());
		System.out.println("props - " + collectionBean.getSomeProps());
		
		SpringFooBean springFooBean = (SpringFooBean) applicationContext
				.getBean("springFooBean");
		springFooBean.foo();

		applicationContext.close();
	}
}
