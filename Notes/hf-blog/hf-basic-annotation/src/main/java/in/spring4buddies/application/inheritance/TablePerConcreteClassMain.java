package in.spring4buddies.application.inheritance;

import in.spring4buddies.application.config.HibernateConfig;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TablePerConcreteClassMain {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Person person = new Person("Steve", "Balmer");
		person.setPersonId(1L);
		session.save(person);

		Customer customer = new Customer("James", "Gosling", "Marketing", new Date());
		customer.setPersonId(2L);
		session.save(customer);

		Owner owner = new Owner("Bill", "Gates", 300L, 20L);
		owner.setPersonId(3L);
		session.save(owner);

		session.getTransaction().commit();
		session.close();

		HibernateConfig.shuntdown();
	}
}