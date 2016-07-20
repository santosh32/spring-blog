package in.spring4buddies.application;

import in.spring4buddies.application.config.HibernateConfig;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Application {

	public static void main(String[] args) {
		// save();
//		update();
		// saveOrUpdate();
		persist() ;
//		merge();
	}

	public static void save() {
		System.out.println("==============================");
		System.out.println("executing the save() ");

		Session session = HibernateConfig.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		Student student = new Student(22, "Ram");
		
		long sid = (long) session.save(student);
		
		System.out.println("Generated Identifier:" + sid);
		
		transaction.commit();
		
		session.close();
	}

	public static void saveOrUpdate() {
		System.out.println("==============================");
		System.out.println("executing the saveOrUpdate() ");
		Session session = HibernateConfig.getSessionFactory().openSession();
		Student student = new Student(1100, 22, "Ram");
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(student);
		transaction.commit();
		session.close();
	}

	public static void update() {
		System.out.println("==============================");
		System.out.println("executing the update() ");
		Session session = HibernateConfig.getSessionFactory().openSession();
		Student student = new Student(1100, 22, "Mahesh");
		Transaction transaction = session.beginTransaction();
		session.update(student);
		transaction.commit();
		session.close();
	}

	public static void persist() {
		System.out.println("===================================");
		System.out.println("**** executing the persist() ******");

		Session session = HibernateConfig.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		Student student = new Student(22, "Ram");
		
		session.persist(student);
		
		System.out.println("Generated Identifier persist :" + student.getId());
		
		transaction.commit();
		session.close();
		
		System.out.println("===================================");
	}

	public static void merge() {
		System.out.println("==============================");
		System.out.println("executing the merge() ");
		Session session = HibernateConfig.getSessionFactory().openSession();
		Student student = new Student(1100, 22, "Ram");
		Transaction transaction = session.beginTransaction();
		student = (Student) session.merge(student);
		System.out.println("Generated Identifier merge :" + student);
		transaction.commit();
		session.close();
	}
}
