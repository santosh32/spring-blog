package in.spring4buddies.application.config;

import in.spring4buddies.application.basic.Student;
import in.spring4buddies.application.collection.Address;
import in.spring4buddies.application.collection.Employee;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateConfig {

	private static SessionFactory sessionFactory;
	
	static {
		
//		Configuration configuration = new Configuration().configure();
//		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
//				.applySettings(configuration.getProperties());
//		sessionFactory = configuration.buildSessionFactory(builder.build());

		Configuration configuration = new Configuration()
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Address.class)
				
				// ORACLE
				.setProperty("hibernate.dialect", org.hibernate.dialect.Oracle10gDialect.class.getName())
				
				.setProperty("hibernate.connection.driver_class", oracle.jdbc.driver.OracleDriver.class.getName())
				.setProperty("hibernate.connection.url", "jdbc:oracle:thin:@localhost:1522:orcl")
				.setProperty("hibernate.connection.username", "srlp")
				.setProperty("hibernate.connection.password", "srlp")
				
				// HSQL
//				.setProperty("hibernate.dialect", org.hibernate.dialect.HSQLDialect.class.getName())
//				
//				.setProperty("hibernate.connection.driver_class", org.hsqldb.jdbcDriver.class.getName())
//				.setProperty("hibernate.connection.url", "jdbc:hsqldb:mem:testdb")
//				.setProperty("hibernate.connection.username", "sa")
//				.setProperty("hibernate.connection.password", "")
				
				.setProperty("show_sql", "true")
				.setProperty("format_sql", "true")
				
				.setProperty("connection.autocommit", "true")
				
				.setProperty("hibernate.hbm2ddl.auto", "update")
			.configure();
		
		StandardServiceRegistryBuilder serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		sessionFactory = configuration.buildSessionFactory(serviceRegistry.build());
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shuntdown() {
		sessionFactory.close();
	}
}