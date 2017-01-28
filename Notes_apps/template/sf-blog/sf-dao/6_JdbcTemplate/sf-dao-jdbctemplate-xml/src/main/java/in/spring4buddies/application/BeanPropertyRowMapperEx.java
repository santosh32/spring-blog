package in.spring4buddies.application;

import in.spring4buddies.application.dao.CustomerDao;
import in.spring4buddies.application.model.Customer;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanPropertyRowMapperEx {

	public static void main(String[] args) throws Exception {
		String confFile = "beans.xml";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(confFile);

		CustomerDao customerDao = (CustomerDao) context.getBean("customerDao");

		System.out.println(" *****  Select customer ******");
		List<Customer> customers = customerDao.findAll();
		for (Customer customer : customers) {
			System.out.println(customer.getCust_Id() + " | " + customer.getName() + " | " + customer.getSalary() + " | " + customer.getDept());
		}

		context.close();
	}
}
