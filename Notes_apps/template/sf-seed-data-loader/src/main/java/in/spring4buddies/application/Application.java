package in.spring4buddies.application;

import in.spring4buddies.application.csv.CSVHeader;
import in.spring4buddies.application.csv.CSVRearder;
import in.spring4buddies.application.dao.GenericDao;
import in.spring4buddies.application.seeddata.Customer;
import in.spring4buddies.application.seeddata.Employee;

import java.lang.reflect.Field;
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
		
		List<Employee> employees = CSVRearder.getDataByCSV(Employee.class);

		for (Employee employee : employees) {
			Field[] fields = employee.getClass().getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				String name = field.getName();
				System.out.println(name + "-" + field.get(employee));
			}
		}

	}

	// Insert into customer (customerId, contact, address, city, firstOrder,
	// state, zipCode, country, phone, name ) values (14324742,'A. BAUM','5089
	// CALERO AVENUE','SAN
	// JOSE','05-Feb-70','CA','95123','USA','408629-0589','SANTA CLARA VALLEY
	// TECHNOLOGY SPECIALISTS')
	private static <T> void iterate(List<T> data) {
		for (T t : data) {
			System.out.println(t);
		}
	}
}
