package in.spring4buddies.application;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PropertiesLauncher {

	public static void main(String args[]) {

		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"beans_properties.xml");

		BasicDataSource basicDataSource = applicationContext
				.getBean(BasicDataSource.class);

		System.out.println("DriverClassName : " + basicDataSource.getDriverClassName());
		System.out.println("Url : " + basicDataSource.getUrl());
		System.out.println("Username : " + basicDataSource.getUsername());
		System.out.println("Password : " + basicDataSource.getPassword());

		applicationContext.close();
	}
}
