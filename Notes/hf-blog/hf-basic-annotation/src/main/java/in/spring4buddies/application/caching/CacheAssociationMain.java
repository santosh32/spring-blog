/*package in.spring4buddies.application.caching;

import java.awt.print.Book;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CacheAssociationMain {
	public static void main(String args[]) {
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Book book1 = new Book();
		book1.setName("Book1");
		Book book2 = new Book();
		book2.setName("Book2");

		Set<Book> books = new HashSet<Book>();

		books.add(book1);
		books.add(book2);

		session.save(book1);

		session.save(book2);
		Student student = new Student();
		student.setName("Student A");
		student.setBooksBorrowed(books);

		int id = (Integer) session.save(student);

		tx.commit();
		session.close();

		session = factory.openSession();

		Student st1 = (Student) session.get(Student.class, id);
		Student st2 = (Student) session.get(Student.class, id);

		System.out.println(st1.getBooksBorrowed());
		System.out.println(st2.getBooksBorrowed());

		session.close();

		session = factory.openSession();

		Student st3 = (Student) session.get(Student.class, id);
		System.out.println(st3.getBooksBorrowed());

		Student st4 = (Student) session.get(Student.class, id);
		System.out.println(st4.getBooksBorrowed());

		session.close();
		factory.close();
	}
}*/