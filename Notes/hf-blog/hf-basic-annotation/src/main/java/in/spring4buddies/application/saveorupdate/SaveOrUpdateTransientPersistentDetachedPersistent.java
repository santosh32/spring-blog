package in.spring4buddies.application.saveorupdate;

import in.spring4buddies.application.collection.Address;
import in.spring4buddies.application.collection.Employee;
import in.spring4buddies.application.config.HibernateConfig;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class SaveOrUpdateTransientPersistentDetachedPersistent {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Employee employee = getTestEmployee();

		System.out.println("\n1. before Employee 'saveOrUpdate' called, id="+ employee.getId());

		session.saveOrUpdate(employee);

		System.out.println("\n2. after Employee 'saveOrUpdate' called, id="+ employee.getId());

		System.out.println("\n3. before Employee 'commit' called");

		tx.commit();

		System.out.println("\n4. after Employee 'commit' called");

		session.close();

		System.out.println("==========================================");

		Session session1 = sessionFactory.openSession();
		Transaction tx1 = session1.beginTransaction();

		employee.setName("your name updated");
		employee.getAddress().setCity("Hyd");

		System.out.println("\n1. before Employee 'saveOrUpdate' called, eid="+ employee.getId()+" aid="+ employee.getAddress().getId());

		session1.saveOrUpdate(employee);
//		session1.saveOrUpdate(employee.getAddress());

		System.out.println("\n2. after Employee 'saveOrUpdate' called,  eid="+ employee.getId()+" aid="+ employee.getAddress().getId());
		
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

1. before Employee 'saveOrUpdate' called, id=0
Hibernate: call next value for employee_seq
Hibernate: call next value for address_seq

2. after Employee 'saveOrUpdate' called, id=450

3. before Employee 'commit' called
Hibernate: insert into EMPLOYEE (emp_name, emp_salary, emp_id) values (?, ?, ?)
Hibernate: insert into ADDRESS (address_line1, city, employee_emp_id, zipcode, id) values (?, ?, ?, ?, ?)

4. after Employee 'commit' called
==========================================

1. before Employee 'saveOrUpdate' called, eid=450 aid=350

2. after Employee 'saveOrUpdate' called,  eid=450 aid=350

3. before Employee 'commit' called
Hibernate: update EMPLOYEE set emp_name=?, emp_salary=? where emp_id=?
Hibernate: update ADDRESS set address_line1=?, city=?, employee_emp_id=?, zipcode=? where id=?

4. after Employee 'commit' called

	*/