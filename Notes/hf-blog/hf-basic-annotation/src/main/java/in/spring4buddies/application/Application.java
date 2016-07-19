package in.spring4buddies.application;

import in.spring4buddies.application.config.HibernateUtil;

import org.hibernate.Session;

public class Application {

	public static void main(String[] args) {
		save();
		update();
//		saveOrUpdate();
	}

	public static void save() {
		System.out.println("==============================");
		System.out.println("executing the save() ");
		Session session = HibernateUtil.getSessionFactory().openSession();
		Student student = new Student(1, 22, "Ram");
		session.beginTransaction();
		long id = (long) session.save(student);
		System.out.println("Generated Identifier:" + id);
		session.getTransaction().commit();
		session.close();
	}

	public static void saveOrUpdate() {
		System.out.println("==============================");
		System.out.println("executing the saveOrUpdate() ");
		Session session = HibernateUtil.getSessionFactory().openSession();
		Student s = new Student(1, 25, "Ram");
		session.beginTransaction();
		session.saveOrUpdate(s);
		session.getTransaction().commit();
		session.close();
	}

	public static void update() {
		System.out.println("==============================");
		System.out.println("executing the update() ");
		Session session = HibernateUtil.getSessionFactory().openSession();
		Student s = new Student(1, 22, "Mahesh");
		session.beginTransaction();
		session.update(s);
		session.getTransaction().commit();
		session.close();
	}
}
