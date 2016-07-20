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
		Employee emp = (Employee) session.load(Employee.class, new Long(101));
		System.out.println("Employee object loaded. " + emp);
		tx.commit();

		// update example
		emp.setName("Updated name");
		emp.getAddress().setCity("Bangalore");
		Transaction tx7 = session.beginTransaction();
		session.update(emp);
		emp.setName("Final updated name");
		System.out.println("13. Before committing update transaction");
		tx7.commit();
		System.out.println("14. After committing update transaction");

		// Close resources
		sessionFactory.close();
	}
}