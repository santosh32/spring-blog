package in.spring4buddies.application.basic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.dialect.HSQLDialect;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StatesWithCUDTx {

	private static SessionFactory sessionFactory;

	private Session session;

	@BeforeClass
	public static void beforeTests() {
		Configuration configuration = new Configuration()
				.addAnnotatedClass(Student.class)
				.setProperty("hibernate.dialect", HSQLDialect.class.getName())
				.setProperty("hibernate.connection.driver_class",
						org.hsqldb.jdbcDriver.class.getName())
				.setProperty("hibernate.connection.url", "jdbc:hsqldb:mem:test")
				.setProperty("hibernate.connection.username", "sa")
				.setProperty("hibernate.connection.password", "")
				.setProperty("hibernate.hbm2ddl.auto", "update");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	@Before
	public void setUp() {
		session = sessionFactory.openSession();
		session.beginTransaction();
	}

	@Test
	public void whenPersistTransient_thenSavedToDatabaseOnCommit() {

		Student student = new Student();
		student.setName("John");
		session.persist(student);

		session.getTransaction().commit();
		session.close();

		session = sessionFactory.openSession();
		session.beginTransaction();

		assertNotNull(session.get(Student.class, student.getId()));

	}

	@Test
	public void whenPersistPersistent_thenNothingHappens() {

		Student student = new Student();
		student.setName("John");

		session.persist(student);
		Long id1 = student.getId();

		session.persist(student);
		Long id2 = student.getId();

		assertEquals(id1, id2);
	}

	@Test(expected = HibernateException.class)
	public void whenPersistDetached_thenThrowsException() {

		Student student = new Student();
		student.setName("John");
		session.persist(student);
		session.evict(student);

		session.persist(student);

	}

	@Test
	public void whenSaveTransient_thenIdGeneratedImmediately() {

		Student student = new Student();
		student.setName("John");

		assertNull(student.getId());

		long id = (long) session.save(student);

		assertNotNull(id);

		session.getTransaction().commit();
		session.close();

		assertEquals(id, student.getId());

		session = sessionFactory.openSession();
		session.beginTransaction();

		assertNotNull(session.get(Student.class, student.getId()));

	}

	@Test
	public void whenSavePersistent_thenNothingHappens() {

		Student student = new Student();
		student.setName("John");
		Long id1 = (Long) session.save(student);
		Long id2 = (Long) session.save(student);
		assertEquals(id1, id2);

	}

	@Test
	public void whenSaveDetached_thenNewInstancePersisted() {

		Student student = new Student();
		student.setName("John");
		Long id1 = (Long) session.save(student);
		session.evict(student);

		Long id2 = (Long) session.save(student);
		assertNotEquals(id1, id2);

	}

	@Test
	public void whenMergeDetached_thenEntityUpdatedFromDatabase() {

		Student student = new Student();
		student.setName("John");
		session.save(student);
		session.evict(student);

		student.setName("Mary");
		Student mergedStudent = (Student) session.merge(student);

		assertNotSame(student, mergedStudent);
		assertEquals("Mary", mergedStudent.getName());

	}

	@Test
	public void whenMergeTransient_thenNewEntitySavedToDatabase() {

		Student Student = new Student();
		Student.setName("John");
		Student mergedStudent = (Student) session.merge(Student);

		session.getTransaction().commit();
		session.beginTransaction();

		assertNull(Student.getId());
		assertNotNull(mergedStudent.getId());

	}

	@Test
	public void whenMergePersistent_thenReturnsSameObject() {

		Student student = new Student();
		student.setName("John");
		session.save(student);

		Student mergedStudent = (Student) session.merge(student);

		assertSame(student, mergedStudent);

	}

	@Test
	public void whenUpdateDetached_thenEntityUpdatedFromDatabase() {

		Student student = new Student();
		student.setName("John");
		session.save(student);
		session.evict(student);

		student.setName("Mary");
		session.update(student);
		assertEquals("Mary", student.getName());

	}

	@Test(expected = HibernateException.class)
	public void whenUpdateTransient_thenThrowsException() {

		Student student = new Student();
		student.setName("John");
		session.update(student);

	}

	@Test
	public void whenUpdatePersistent_thenNothingHappens() {

		Student student = new Student();
		student.setName("John");
		session.save(student);

		session.update(student);

	}

	@Test
	public void whenSaveOrUpdateDetached_thenEntityUpdatedFromDatabase() {

		Student student = new Student();
		student.setName("John");
		session.save(student);
		session.evict(student);

		student.setName("Mary");
		session.saveOrUpdate(student);
		assertEquals("Mary", student.getName());

	}

	@Test
	public void whenSaveOrUpdateTransient_thenSavedToDatabaseOnCommit() {

		Student student = new Student();
		student.setName("John");
		session.saveOrUpdate(student);

		session.getTransaction().commit();
		session.close();

		session = sessionFactory.openSession();
		session.beginTransaction();

		assertNotNull(session.get(Student.class, student.getId()));

	}

	@Test
	public void whenSaveOrUpdatePersistent_thenNothingHappens() {

		Student student = new Student();
		student.setName("John");
		session.save(student);

		session.saveOrUpdate(student);

	}

	@After
	public void tearDown() {
		session.getTransaction().commit();
		session.close();
	}

	@AfterClass
	public static void afterTests() {
		sessionFactory.close();
	}

}