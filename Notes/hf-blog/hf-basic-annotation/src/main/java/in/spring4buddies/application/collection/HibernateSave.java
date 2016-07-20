package in.spring4buddies.application.collection;

import in.spring4buddies.application.config.HibernateConfig;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateSave {

	public static void main(String[] args) {

		// Prep Work
		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();

		// save example - without transaction
		Session session = sessionFactory.openSession();
		
		Employee employee = getTestEmployee();
		
		System.out.println("1. before Employee save called without transaction, id=" + employee.getId());
		long id = (Long) session.save(employee);
		System.out.println("1. after Employee save called without transaction, id=" + employee.getId());

		session.flush(); // address will not get saved without this
		
		Employee loadedEmp = (Employee) session.load(Employee.class, new Long(id));
		System.out.println("Employee ID - " + loadedEmp.getId());
		System.out.println("Address ID - " + ((loadedEmp.getAddress() != null) ? loadedEmp.getAddress().getAddressLine1() : null));
		System.out.println("***************************************************");

		// save example - with transaction
		Session session1 = sessionFactory.openSession();
		Transaction tx1 = session1.beginTransaction();
		
		Employee employee1 = getTestEmployee();
		
		long id1 = (Long) session1.save(employee1);
		System.out.println("2. Employee save called with transaction, id=" + id1);
		System.out.println("3. Before committing save transaction");
		
		tx1.commit();
		
		System.out.println("4. After committing save transaction");
		
		Employee loadedEmp1 = (Employee) session1.load(Employee.class, new Long(id1));
		System.out.println("Employee ID - " + loadedEmp1.getId());
		System.out.println("Address ID - " + ((loadedEmp1.getAddress() != null) ? loadedEmp1.getAddress().getId() : null));
		System.out.println("***************************************************");

		// save example - existing row in table
		Session session2 = sessionFactory.openSession();
		Transaction tx2 = session2.beginTransaction();
		
		Employee employee2 = (Employee) session2.load(Employee.class, new Long(250));

		// update some data
		employee2.setName("New Name 1");
		employee2.getAddress().setCity("New City");

		long id6 = (Long) session2.save(employee2);
		
		employee2.setName("New Name12"); // will get updated in database
		System.out.println("5. Employee save called with transaction, id="+ id6);
		System.out.println("6. Before committing save transaction");
		
		tx2.commit();
		System.out.println("7. After committing save transaction");
		
		System.out.println("Employee ID - " + employee2.getId());
		if (employee2.getAddress() != null) {
			System.out.println("Address ID - " + employee2.getAddress().getId());
		}
		System.out.println("***************************************************");

		// Close resources
		sessionFactory.close();

	}

	public static Employee getTestEmployee() {
		Employee employee = new Employee();
		Address address = new Address();
		employee.setName("Test Emp");
		employee.setSalary(1000);
		address.setAddressLine1("Test address1");
		address.setCity("Test City");
		address.setZipcode("12121");
		employee.setAddress(address);
		address.setEmployee(employee);
		return employee;
	}
}