package in.spring4buddies.application;

import in.spring4buddies.application.csv.CSVRearder;
import in.spring4buddies.application.seeddata.Customer;
import in.spring4buddies.application.seeddata.Employee;
import in.spring4buddies.application.seeddata.Invoice;
import in.spring4buddies.application.seeddata.OrderItem;
import in.spring4buddies.application.seeddata.Staff;

import java.util.List;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class Application {

	public static void main(String args[]) throws Exception {

//		String confFile = "beans.xml";
//		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(confFile);
//
//		GenericDao genericDao = (GenericDao) context.getBean("genericDao");
//
//		List<Customer> customers = genericDao.getAll(Customer.class);
//		iterate(customers);
//
//		List<Employee> employees = genericDao.getAll(Employee.class);
//		iterate(employees);
//
//		List<Invoice> invoices = genericDao.getAll(Invoice.class);
//		iterate(invoices);
//
//		List<OrderItem> orders = genericDao.getAll(OrderItem.class);
//		iterate(orders);
//
//		List<Staff> staffs = genericDao.getAll(Staff.class);
//		iterate(staffs);
//
//		context.close();

		iterate(CSVRearder.getDataByCSV(Customer.class));
		 iterate(CSVRearder.getDataByCSV(Employee.class));
		 iterate(CSVRearder.getDataByCSV(Invoice.class));
		 iterate(CSVRearder.getDataByCSV(OrderItem.class));
		 iterate(CSVRearder.getDataByCSV(Staff.class));

		// iterate(DBStatement.insert(CSVRearder.getDataByCSV(Employee.class)));
		// iterate(DBStatement.insert(CSVRearder.getDataByCSV(Invoice.class)));
		// iterate(DBStatement.insert(CSVRearder.getDataByCSV(OrderItem.class)));
		// iterate(DBStatement.insert(CSVRearder.getDataByCSV(Staff.class)));

		// System.out.println(DBStatement.create(Employee.class));
		// System.out.println(DBStatement.create(Invoice.class));
		// System.out.println(DBStatement.create(OrderItem.class));
		// System.out.println(DBStatement.create(Staff.class));

	}

	private static <T> void iterate(List<T> data) {
		for (T t : data) {
			System.out.println(t);
		}
	}
}
