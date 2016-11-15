package in.spring4buddies.application.config;

import in.spring4buddies.application.basic.Student;

import java.util.Iterator;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.mapping.RootClass;

public class HibernateConfig {

	private static SessionFactory sessionFactory;
	
	static {
		
//		Configuration configuration = new Configuration().configure();
//		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
//				.applySettings(configuration.getProperties());
//		sessionFactory = configuration.buildSessionFactory(builder.build());

		Configuration configuration = new Configuration()
				.addAnnotatedClass(Student.class)
//				.addAnnotatedClass(Employee.class)
//				.addAnnotatedClass(Address.class)
//				.addAnnotatedClass(Stock.class)
//				.addAnnotatedClass(StockDetail.class)
//				.addAnnotatedClass(StockDailyRecord.class)
//				.addAnnotatedClass(StockCategory.class)
//				.addAnnotatedClass(Blog.class)
//				.addAnnotatedClass(Comment.class)
				.addPackage("in.spring4buddies.application.*")
				
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
//				.setProperty("hibernate.connection.url", "jdbc:hsqldb:hsql://localhost:9001/mydb/xdb")
//				.setProperty("hibernate.connection.username", "sa")
//				.setProperty("hibernate.connection.password", "")
				
				.setProperty("show_sql", "true")
//				.setProperty("format_sql", "true")
				
//				.setProperty("connection.autocommit", "true")
				
				.setNamingStrategy(new MyNamingStrategy())
				
				.setProperty("hibernate.hbm2ddl.auto", "update");
			
		Iterator<PersistentClass> iterator = configuration.getClassMappings();
		 while (iterator.hasNext()) {              
             RootClass rootClass = (RootClass)iterator.next();
             System.out.println("&&&&: "+rootClass.getTable().getName());
             if (rootClass.getTable().getName().equals("CHA20P")){
                rootClass.getTable().setSchema("testschema"); 
                break;                           
             }
             
           }
		
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
	
//	public static SessionFactory getSessionFactoryFromProperties()
//			throws IOException {
//
//		// Create configuration instance
//		Configuration configuration = new Configuration();
//		// Create properties file
//		Properties properties = new Properties();
//		properties.load(Thread.currentThread().getContextClassLoader()
//				.getResourceAsStream("hibernate.properties"));
//		// Pass hibernate properties file
//		configuration.setProperties(properties);
//		// Since version 4.x, service registry is being used
//		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//				.applySettings(configuration.getProperties()).build();
//		// Create session factory instance
//		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//		
//		return sessionFactory;
//	}
}