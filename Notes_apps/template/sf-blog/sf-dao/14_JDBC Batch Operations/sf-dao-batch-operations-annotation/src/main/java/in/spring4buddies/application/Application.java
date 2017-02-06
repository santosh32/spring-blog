package in.spring4buddies.application;

import in.spring4buddies.application.dao.StaffDao;
import in.spring4buddies.application.model.Staff;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String args[]) throws Exception {

		String confFile = "beans.xml";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(confFile);

		StaffDao staffDao = (StaffDao) context.getBean("staffDao");

		List<Staff> staffs = CSVRearder.getStaffData(Staff.class, new String[] { "staffId", "lLame", "fName", "city", "state", "hPhone" });
		staffDao.insert(staffs);

		context.close();
	}
}
