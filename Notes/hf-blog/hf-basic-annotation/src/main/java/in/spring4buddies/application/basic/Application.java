package in.spring4buddies.application.basic;

import in.spring4buddies.application.config.HibernateConfig;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Application {

	public static void main(String[] args) {

		System.out.println("S 'Save'");
		System.out.println("U 'Update'");
		System.out.println("SU 'SaveOrUpdate'");
		System.out.println("P 'persist'");
		System.out.println("M 'Merge'");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please select the above option >>>  ");
		String input = scanner.next();
		
		switch (input.toUpperCase()) {
		case "S":
			save();
			break;
		case "U":
			update();
			break;
		case "SU":
			saveOrUpdate();
			break;
		case "P":
			persist();
			break;
		case "M":
			merge();
			break;
		default:
			save();
			update();
			saveOrUpdate();
			persist();
			merge();
		}

		scanner.close();
	}

	public static void save() {
		System.out.println("==============================");
		System.out.println(" ****** executing the save() ****** ");

		Session session = HibernateConfig.getSessionFactory().openSession();
		 Transaction transaction = session.beginTransaction();

		Student student = new Student(22, "Ram111");

		long sid = (long) session.save(student);

		System.out.println("Generated Identifier:" + sid);

		 transaction.commit();
//		session.flush();

		session.close();
		System.out.println("===================================");
	}

	public static void saveOrUpdate() {
		System.out.println("==============================");
		System.out.println(" ****** executing the saveOrUpdate()  ****** ");

		Session session = HibernateConfig.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

//		Student student = new Student(3100, 23, "Ram updae ");
		Student student = new Student(89, "Rajesh ");

		session.saveOrUpdate(student);
		
		transaction.commit();
//		session.flush();
		
		session.close();
		System.out.println("===================================");
	}

	public static void update() {
		System.out.println("==============================");
		System.out.println(" ****** executing the update() ****** ");

		Session session = HibernateConfig.getSessionFactory().openSession();
//		Transaction transaction = session.beginTransaction();

		Student student = new Student(3100, 22, "Mahesh");

		session.update(student);
		session.flush();
//		transaction.commit();

		session.close();
		System.out.println("===================================");
	}

	public static void persist() {
		System.out.println("===================================");
		System.out.println("**** executing the persist() ******");

		Session session = HibernateConfig.getSessionFactory().openSession();
		// Transaction transaction = session.beginTransaction();

		Student student = new Student(22, "Ram");

		session.persist(student);
		session.flush();

		System.out.println("Generated Identifier persist :" + student.getId());

		// transaction.commit();
		session.close();

		System.out.println("===================================");
	}

	public static void merge() {
		System.out.println("==============================");
		System.out.println(" ****** executing the merge()  ****** ");

		Session session = HibernateConfig.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		Student student = new Student(3100, 99, "santosh");

		student = (Student) session.merge(student);

		System.out.println("Generated Identifier merge :" + student);

		transaction.commit();
		session.close();

		System.out.println("===================================");
	}
}
