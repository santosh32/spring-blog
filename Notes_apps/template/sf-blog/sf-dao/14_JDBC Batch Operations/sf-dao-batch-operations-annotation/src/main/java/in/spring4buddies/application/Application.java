package in.spring4buddies.application;

import in.spring4buddies.application.dao.CommonDao;
import in.spring4buddies.application.model.Customer;
import in.spring4buddies.application.model.Employee;
import in.spring4buddies.application.model.Invoice;
import in.spring4buddies.application.model.Order;
import in.spring4buddies.application.model.Staff;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String args[]) throws Exception {

		String confFile = "beans.xml";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(confFile);

		CommonDao commonDao = (CommonDao) context.getBean("commonDao");

		List<Staff> staffs = CSVRearder.getDataByCSV(Staff.class, "csv/Staff.csv", new String[] { "staff_Id", "last_name", "first_name", "city",
				"state", "home_phone" });
		commonDao.insertStaff(staffs);

		List<Customer> customers = CSVRearder.getDataByCSV(Customer.class, "csv/Customer.csv", new String[] { "customerId", "contact", "address",
				"city", "firstOrder", "state", "zipCode", "country", "phone", "name" });
		commonDao.insertCustomer(customers);

		List<Employee> employees = CSVRearder.getDataByCSV(Employee.class, "csv/Employee.csv", new String[] { "empId", "hireDate", "salary", "dept",
				"jobcode", "sex", "birthDate", "lastName", "firstName", "middleName", "phone" });
		commonDao.insertEmployee(employees);

		List<Invoice> invoices = CSVRearder.getDataByCSV(Invoice.class, "csv/Invoice.csv", new String[] { "invoiceId", "billedTo", "amtBilled",
				"country", "amtInUS", "billedBy", "billedOn", "paidOn" });
		commonDao.insertInvoice(invoices);

		List<Order> orders = CSVRearder.getDataByCSV(Order.class, "csv/OrderItem.csv", new String[] { "orderId", "stockId", "length", "fabCharges",
				"shipTo", "orderDate", "shipped", "takenBy", "proccessdBy", "specinstr" });
		commonDao.insertOrder(orders);

		context.close();
	}
}
