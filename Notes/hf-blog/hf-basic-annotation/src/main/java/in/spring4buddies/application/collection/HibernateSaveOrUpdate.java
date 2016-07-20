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
		Session session5 = sessionFactory.openSession();
		Employee emp5 = HibernateSave.getTestEmployee();
		session5.saveOrUpdate(emp5);
		System.out.println("***************************");

		// saveOrUpdate example - with transaction
		Session session3 = sessionFactory.openSession();
		Transaction tx3 = session3.beginTransaction();
		
		Employee emp3 = HibernateSave.getTestEmployee();
		session3.saveOrUpdate(emp3);
		
		emp3.setName("Kumar"); // will be saved into DB
		System.out.println("9. Before committing saveOrUpdate transaction. Id=" + emp3.getId());
		
		tx3.commit();
		System.out.println("10. After committing saveOrUpdate transaction");
		System.out.println("***************************");

		Transaction tx4 = session3.beginTransaction();
		emp3.setName("Updated Test Name"); // Name changed
		emp3.getAddress().setCity("Updated City");
		
		session3.saveOrUpdate(emp3);
		emp3.setName("Kumar"); // again changed to previous value, so no
								// Employee update
		System.out.println("11. Before committing saveOrUpdate transaction. Id=" + emp3.getId());
		tx4.commit();
		
		System.out.println("12. After committing saveOrUpdate transaction");
		System.out.println("***************************");

		// Close resources
		sessionFactory.close();

	}
}