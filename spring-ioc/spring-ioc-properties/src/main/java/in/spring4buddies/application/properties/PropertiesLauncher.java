package in.spring4buddies.application.properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class PropertiesLauncher {

	public static void main(String args[]) {

		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"beans_properties.xml");

		BasicDataSource basicDataSource = applicationContext.getBean(BasicDataSource.class);

		System.out.println("************* BasicDataSource propeties ************");
		System.out.println("DriverClassName : " + basicDataSource.getDriverClassName());
		System.out.println("Url : " + basicDataSource.getUrl());
		System.out.println("Username : " + basicDataSource.getUsername());
		System.out.println("Password : " + basicDataSource.getPassword());
		
		
		JavaMailSenderImpl javaMailSenderImpl = applicationContext.getBean(JavaMailSenderImpl.class);
		System.out.println("\n\n************* BasicDataSource propeties ************");
		System.out.println("Host : " + javaMailSenderImpl.getHost());
		System.out.println("Port : " + javaMailSenderImpl.getPort());
		System.out.println("Username : " + javaMailSenderImpl.getUsername());
		System.out.println("Password : " + javaMailSenderImpl.getPassword());

		applicationContext.close();
	}
}
