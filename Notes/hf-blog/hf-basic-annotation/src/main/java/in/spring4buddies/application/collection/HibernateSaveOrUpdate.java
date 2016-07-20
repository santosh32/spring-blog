package in.spring4buddies.application.collection;

import in.spring4buddies.application.config.HibernateConfig;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateSaveOrUpdate {

	public static void main(String[] args) {

		// Prep Work
		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();

		// saveOrUpdate example - without transaction
		Session session = sessionFactory.openSession();
		
		Employee employee = HibernateSave.getTestEmployee();
		session.saveOrUpdate(employee);
		
		System.out.println("***************************");

		// saveOrUpdate example - with transaction
		Session session1 = sessionFactory.openSession();
		Transaction tx = session1.beginTransaction();
		
		Employee employee1 = HibernateSave.getTestEmployee();
		session1.saveOrUpdate(employee1);
		
		employee1.setName("Kumar"); // will be saved into DB
		System.out.println("9. Before committing saveOrUpdate transaction. Id=" + employee1.getId());
		
		tx.commit();
		
		System.out.println("10. After committing saveOrUpdate transaction");
		System.out.println("***************************");

		Transaction tx1 = session1.beginTransaction();
		employee1.setName("Updated Test Name"); // Name changed
		employee1.getAddress().setCity("Updated City");
		
		session1.saveOrUpdate(employee1);
		
		employee1.setName("Kumar"); // again changed to previous value, so no
								// Employee update
		System.out.println("11. Before committing saveOrUpdate transaction. Id=" + employee1.getId());
		
		tx1.commit();
		
		System.out.println("12. After committing saveOrUpdate transaction");
		System.out.println("***************************");

		// Close resources
		sessionFactory.close();

	}
}