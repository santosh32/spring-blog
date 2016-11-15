package in.spring4buddies.application.inverse;

import in.spring4buddies.application.config.HibernateConfig;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class inverseMain {

	public static void main(String[] args) {

//		save();
//		 load();

		 save1();
		 load1();
	}

	private static void save() {

		System.out.println("Hibernate one to many (Annotation)");

		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		Blog blog = new Blog();

		blog.setName("Blog name 1");

		Comment comment = new Comment();
		comment.setCommentDesc("Comment Desc 1");
		comment.setCommentName("Comment Name 1 ");

		blog.getComments().add(comment);
		comment.setBlog(blog);

		session.save(blog);
		// session.save(comment);

		session.getTransaction().commit();

		HibernateConfig.shuntdown();

		System.out.println("== Done == ");
	}

	private static void save1() {

		System.out.println("Hibernate one to many (Annotation)");

		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		Blog blog = new Blog();

		blog.setName("Blog name 1");

//		Comment comment = new Comment();
//		comment.setCommentDesc("Comment Desc 1");
//		comment.setCommentName("Comment Name 1 ");
//
//		blog.getComments().add(comment);
//		comment.setBlog(blog);

		session.save(blog);
		// session.save(comment);

		session.getTransaction().commit();

		HibernateConfig.shuntdown();

		System.out.println("== Done == ");
	}

	private static void load() {

		System.out.println("Hibernate many to many (Annotation)");
		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
		Session session = sessionFactory.openSession();

		Blog blog = (Blog) session.load(Blog.class, 3200);

		System.out.println(blog);

		if (blog.getComments() != null) {
			System.out.println(blog.getComments());
		}

//		HibernateConfig.shuntdown();

		System.out.println("== Done == ");
	}
	private static void load1() {

		System.out.println("Hibernate many to many (Annotation)");
		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
		Session session = sessionFactory.openSession();

		Blog blog = (Blog) session.load(Blog.class, 3200);

		System.out.println(blog);

		if (blog.getComments() != null) {
			System.out.println(blog.getComments());
		}

		HibernateConfig.shuntdown();

		System.out.println("== Done == ");
	}
}