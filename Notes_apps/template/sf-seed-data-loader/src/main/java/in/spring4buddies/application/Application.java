package in.spring4buddies.application;

import in.spring4buddies.application.dao.GenericDao;
import in.spring4buddies.application.seeddata.Customer;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("unchecked")
public class Application {

	public static void main(String args[]) throws Exception {

		String confFile = "beans.xml";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(confFile);

		GenericDao<Customer> genericDao = (GenericDao<Customer>) context.getBean("genericDao");

		List<Customer> customers = genericDao.getAll(Customer.class);

		iterate(customers);

		context.close();

	}

	private static <T> void iterate(List<T> data) {
		for (T t : data) {
			System.out.println(t);
		}

	}
}
