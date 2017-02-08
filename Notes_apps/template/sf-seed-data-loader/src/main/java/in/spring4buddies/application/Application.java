package in.spring4buddies.application;

import in.spring4buddies.application.csv.CSVRearder;
import in.spring4buddies.application.dao.GenericDao;
import in.spring4buddies.application.seeddata.Customer;
import in.spring4buddies.application.seeddata.Employee;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class Application {

	public static void main(String args[]) throws Exception {

		String confFile = "beans.xml";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(confFile);

		GenericDao genericDao = (GenericDao) context.getBean("genericDao");

		List<Customer> customers = genericDao.getAll(Customer.class);
		iterate(customers);

		List<Employee> employees = genericDao.getAll(Employee.class);
		iterate(employees);

		context.close();

		iterate(DBStatement.insert(CSVRearder.getDataByCSV(Employee.class)));

	}

	private static <T> void iterate(List<T> data) {
		for (T t : data) {
			System.out.println(t);
		}
	}
}
