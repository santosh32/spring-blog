package in.spring4buddies.application;

import in.spring4buddies.application.beans.CollectionBean;
import in.spring4buddies.application.beans.SpringRefBean;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLauncher {

	public static void main(String args[]) {

		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		CollectionBean collectionBean = (CollectionBean) applicationContext
				.getBean("collectionBean");
		System.out.println("list - " + collectionBean.getSomeList());
		System.out.println("set - " + collectionBean.getSomeSet());
		System.out.println("Map - " + collectionBean.getSomeMap());
		System.out.println("props - " + collectionBean.getSomeProps());

		SpringRefBean springRefBean = (SpringRefBean) applicationContext
				.getBean("springRefBean");
		springRefBean.foo();

		applicationContext.close();
	}
}
