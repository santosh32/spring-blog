package in.spring4buddies.application.persist;

import in.spring4buddies.application.collection.Address;
import in.spring4buddies.application.collection.Employee;
import in.spring4buddies.application.config.HibernateConfig;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PersistLoadPersistentDetachedPersistent {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Employee employee = (Employee) session.load(Employee.class, Long.valueOf(350));

		System.out.println("\n1. before Employee 'persist' called, id="+ employee.getId());

		employee.setName("your name updated");
		employee.getAddress().setCity("your city updated");
		
		// not required at this level
//		session.persist(employee);

		System.out.println("\n2. after Employee 'persist' called, id="+ employee.getId());

		System.out.println("\n3. before Employee 'commit' called");

		tx.commit();

		System.out.println("\n4. after Employee 'commit' called");

		session.close();

		System.out.println("----------------------------------------------");

		Session session1 = sessionFactory.openSession();
		Transaction tx1 = session1.beginTransaction();

		employee.setName("your name updated 1 ");
		employee.getAddress().setCity("Hyd 1 ");

		System.out.println("\n1. before Employee 'persist' called, eid="+ employee.getId()+" aid="+ employee.getAddress().getId());

		// you will not procced further from here 
		// Exception in thread "main" org.hibernate.PersistentObjectException: detached entity passed to persist: 
		// in.spring4buddies.application.collection.Employee
		session1.persist(employee);
//		session1.persist(employee.getAddress());

		System.out.println("\n2. after Employee 'persist' called,  eid="+ employee.getId()+" aid="+ employee.getAddress().getId());
		
		System.out.println("\n3. before Employee 'commit' called");

		tx1.commit();

		System.out.println("\n4. after Employee 'commit' called");

		session1.close();

		sessionFactory.close();

	}

	public static Employee getTestEmployee() {
		Employee employee = new Employee();
		employee.setName("Test Employee");
		employee.setSalary(1000);

		Address address = new Address();
		address.setAddressLine1("Test address1");
		address.setCity("Test City");
		address.setZipcode("12121");

		employee.setAddress(address);

		address.setEmployee(employee);

		return employee;
	}
}

/*
output:

Hibernate: select employee0_.emp_id as emp_id1_1_0_, employee0_.emp_name as emp_name2_1_0_, employee0_.emp_salary as emp_sala3_1_0_, address1_.id as id1_0_1_, address1_.address_line1 as address_2_0_1_, address1_.city as city3_0_1_, address1_.employee_emp_id as employee5_0_1_, address1_.zipcode as zipcode4_0_1_ from EMPLOYEE employee0_ left outer join ADDRESS address1_ on employee0_.emp_id=address1_.employee_emp_id where employee0_.emp_id=?

1. before Employee 'persist' called, id=350

2. after Employee 'persist' called, id=350

3. before Employee 'commit' called
Hibernate: update EMPLOYEE set emp_name=?, emp_salary=? where emp_id=?
Hibernate: update ADDRESS set address_line1=?, city=?, employee_emp_id=?, zipcode=? where id=?

4. after Employee 'commit' called
----------------------------------------------

1. before Employee 'persist' called, eid=350 aid=250
Exception in thread "main" org.hibernate.PersistentObjectException: detached entity passed to persist: in.spring4buddies.application.collection.Employee
	*/