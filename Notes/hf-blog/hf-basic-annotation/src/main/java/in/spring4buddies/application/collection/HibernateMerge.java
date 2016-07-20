package in.spring4buddies.application.collection;

import in.spring4buddies.application.config.HibernateConfig;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateMerge {

	public static void main(String[] args) {

		// Prep Work
		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Employee employee = (Employee) session.load(Employee.class, new Long(101));
		System.out.println("Employee object loaded. " + employee);
		
		tx.commit();

		// merge example - data already present in tables
		employee.setSalary(25000);
		
		Transaction tx1 = session.beginTransaction();
		Employee mergedEmployee = (Employee) session.merge(employee);
		
		System.out.println(mergedEmployee == employee); // returns false
		
		employee.setName("Test");
		mergedEmployee.setName("Kumar");
		
		System.out.println("15. Before committing merge transaction");
		
		tx1.commit();
		
		System.out.println("16. After committing merge transaction");

		// Close resources
		sessionFactory.close();

	}

}