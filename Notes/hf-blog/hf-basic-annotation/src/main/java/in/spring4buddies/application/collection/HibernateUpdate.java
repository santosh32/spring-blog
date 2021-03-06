package in.spring4buddies.application.collection;

import in.spring4buddies.application.config.HibernateConfig;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateUpdate {

	public static void main(String[] args) {

		// Prep Work
		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Employee employee = (Employee) session.load(Employee.class, new Long(101));
		System.out.println("Employee object loaded. " + employee);
		tx.commit();

		// update example
		employee.setName("Updated name");
		employee.getAddress().setCity("Bangalore");
		
		Transaction tx7 = session.beginTransaction();
		session.update(employee);
		
		employee.setName("Final updated name");
		
		System.out.println("13. Before committing update transaction");
		
		tx7.commit();
		
		System.out.println("14. After committing update transaction");

		// Close resources
		sessionFactory.close();
	}
}