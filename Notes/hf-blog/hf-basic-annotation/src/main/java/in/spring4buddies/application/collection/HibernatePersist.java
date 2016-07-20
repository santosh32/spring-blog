package in.spring4buddies.application.collection;

import in.spring4buddies.application.config.HibernateConfig;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernatePersist {

	public static void main(String[] args) {

		// Prep Work
		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();

		// persist example - with transaction
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Employee employee = HibernateSave.getTestEmployee();
		
		System.out.println("1. before Employee persist called , id=" + employee.getId());
		session.persist(employee);
		System.out.println("1. after Employee persist called , id=" + employee.getId());
		
		System.out.println("Persist called");
		
		employee.setName("Kumar"); // will be updated in database too
		
		System.out.println("Employee Name updated");
		System.out.println("8. Employee persist called with transaction, id=" + employee.getId() + ", address id=" + employee.getAddress().getId());
		
		tx.commit();
		
		System.out.println("************************************");

		// Close resources
		sessionFactory.close();

	}
}