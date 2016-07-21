package in.spring4buddies.application.merge;

import in.spring4buddies.application.collection.Address;
import in.spring4buddies.application.collection.Employee;
import in.spring4buddies.application.config.HibernateConfig;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MergeTransientPersistentDetachedPersistent {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Employee employee = getTestEmployee();

		System.out.println("\n1. before Employee 'merge' called, id="+ employee.getId());

		session.merge(employee);

		System.out.println("\n2. after Employee 'merge' called, id="+ employee.getId());

		System.out.println("\n3. before Employee 'commit' called");

		tx.commit();

		System.out.println("\n4. after Employee 'commit' called");

		session.close();

		System.out.println("==========================================");

		Session session1 = sessionFactory.openSession();
		Transaction tx1 = session1.beginTransaction();

		employee.setName("your name updated");
		employee.getAddress().setCity("Hyd");

		System.out.println("\n1. before Employee 'merge' called, eid="+ employee.getId()+" aid="+ employee.getAddress().getId());

		session1.merge(employee);
//		session1.merge(employee.getAddress());

		System.out.println("\n2. after Employee 'merge' called,  eid="+ employee.getId()+" aid="+ employee.getAddress().getId());
		
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

1. before Employee 'merge' called, id=0
Hibernate: call next value for employee_seq
Hibernate: call next value for address_seq

2. after Employee 'merge' called, id=0

3. before Employee 'commit' called
Hibernate: insert into EMPLOYEE (emp_name, emp_salary, emp_id) values (?, ?, ?)
Hibernate: insert into ADDRESS (address_line1, city, employee_emp_id, zipcode, id) values (?, ?, ?, ?, ?)

4. after Employee 'commit' called
==========================================

1. before Employee 'merge' called, eid=0 aid=0

2. after Employee 'merge' called,  eid=0 aid=0

3. before Employee 'commit' called
Hibernate: insert into EMPLOYEE (emp_name, emp_salary, emp_id) values (?, ?, ?)
Hibernate: insert into ADDRESS (address_line1, city, employee_emp_id, zipcode, id) values (?, ?, ?, ?, ?)

4. after Employee 'commit' called

	*/