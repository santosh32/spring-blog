package in.spring4buddies.application;

import java.io.IOException;

import in.spring4buddies.application.dao.StaffDao;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
	public static void main(String args[]) throws IOException {
		String confFile = "beans.xml";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(confFile);

		StaffDao staffDao = (StaffDao) context.getBean("staffDao");
		staffDao.insert(CSVRearder.getStaffData());

		context.close();
	}
}
