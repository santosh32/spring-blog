package in.spring4buddies.application.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FirstLevelCacheMain {

	public static void main(String args[]) {
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Student student = new Student();
		student.setName("Student A");

		int id = (Integer) session.save(student);

		tx.commit();
		session.close();

		session = factory.openSession();

		Student student1 = (Student) session.get(Student.class, id);
		Student student2 = (Student) session.get(Student.class, id);
		session.close();

		session = factory.openSession();
		Student student3 = (Student) session.get(Student.class, id);
		session.close();
		factory.close();
	}
}