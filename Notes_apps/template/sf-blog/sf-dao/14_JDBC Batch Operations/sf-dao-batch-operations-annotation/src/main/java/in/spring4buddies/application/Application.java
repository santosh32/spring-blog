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

		List<Staff> staffs = CSVRearder.getDataByCSV(Staff.class, "csv/staff.csv",
				new String[] { "staff_Id", "last_name", "first_name", "city", "state", "home_phone" });

		staffDao.insert(staffs);

		context.close();
	}
}
