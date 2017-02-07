package in.spring4buddies.application;

import in.spring4buddies.application.handler.CSVRearder;
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
//
//		context.close();
		
		List<Staff> staffs = CSVRearder.getDataByCSV(Staff.class, new String[] { "staffId", "lLame", "fName", "city", "state", "hPhone" });

		System.out.println(staffs.size());
	}
}
