package in.spring4buddies.application;

import in.spring4buddies.application.csv.CSVRearder;
import in.spring4buddies.application.seeddata.Customer;
import in.spring4buddies.application.seeddata.Employee;
import in.spring4buddies.application.seeddata.Invoice;
import in.spring4buddies.application.seeddata.Order;
import in.spring4buddies.application.seeddata.Staff;

import java.util.List;

public class Application {

	public static void main(String args[]) throws Exception {

//		String confFile = "beans.xml";
//		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(confFile);
//
//		StaffDao staffDao = (StaffDao) context.getBean("staffDao");
//
//		List<Staff> staffs = CSVRearder.getDataByCSV(Staff.class, "staff.csv",
//				new String[] { "staffId", "lLame", "fName", "city", "state", "hPhone" });
//
//		staffDao.insert(staffs);
		
		iterate(CSVRearder.getDataByCSV(Staff.class));
		iterate(CSVRearder.getDataByCSV(Customer.class));
		iterate(CSVRearder.getDataByCSV(Employee.class));
		iterate(CSVRearder.getDataByCSV(Invoice.class));
		iterate(CSVRearder.getDataByCSV(Order.class));
		
//		context.close();
	}
	
	private static <T> void iterate(List<T> list) {
		for (T t : list) {
			System.out.println(t);
		}

	}
}
