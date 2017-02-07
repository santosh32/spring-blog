package in.spring4buddies.application.csv;

import in.spring4buddies.application.seeddata.Customer;
import in.spring4buddies.application.seeddata.Employee;
import in.spring4buddies.application.seeddata.Invoice;
import in.spring4buddies.application.seeddata.Order;
import in.spring4buddies.application.seeddata.Staff;

import java.util.HashMap;
import java.util.Map;

public class CSVHeader {

	public static Map<Class<?>, String[]> header = new HashMap<>();

	static {
		header.put(Customer.class, new String[] { "customerId", "contact", "address", "city", "firstOrder", "state", "zipCode", "country", "phone", "name" });
		header.put(Employee.class, new String[] { "empId", "hireDate", "salary", "dept", "jobcode", "sex", "birthDate", "lastName", "firstName", "middleName", "phone" });
		header.put(Invoice.class, new String[] { "invoiceId", "billedTo", "amtBilled", "country", "amtInUS", "billedBy", "billedOn", "paidOn" });
		header.put(Order.class, new String[] { "orderId", "stockId", "length", "fabCharges", "shipTo", "orderDate", "shipped", "takenBy", "proccessdBy", "specinstr" });
		header.put(Staff.class, new String[] { "staffId", "lLame", "fName", "city", "state", "hPhone" });
	}

	public static <T> String[] load(Class<T> clazz) {
		return header.get(clazz);
	}
}
