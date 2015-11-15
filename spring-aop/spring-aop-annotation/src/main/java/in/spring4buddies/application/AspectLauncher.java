package in.spring4buddies.application;

import in.spring4buddies.application.annotation.autowired.CustomerDao;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectLauncher {

	public static void main(String args[]) {

		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"beans.xml");

		CustomerDao customerDao = applicationContext.getBean(CustomerDao.class);
		System.out.println("Res  - " + customerDao.getAllCustomer());
		System.out.println("--------------------------------------");
		System.out.println("Res  - " + customerDao.getCustomerById(1));
		System.out.println("--------------------------------------");
		customerDao.createCustomer(null);
		System.out.println("--------------------------------------");

		applicationContext.close();
	}
}
