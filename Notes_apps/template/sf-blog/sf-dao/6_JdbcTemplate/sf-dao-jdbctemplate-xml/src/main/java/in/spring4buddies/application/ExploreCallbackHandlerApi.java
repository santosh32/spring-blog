package in.spring4buddies.application;

import in.spring4buddies.application.dao.CustomerDao;
import in.spring4buddies.application.dao.EmployeeDao;
import in.spring4buddies.application.model.Customer;
import in.spring4buddies.application.model.Employee;

import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExploreCallbackHandlerApi {

	public static void main(String[] args) throws Exception {
		String confFile = "beans.xml";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(confFile);

		EmployeeDao empDao = (EmployeeDao) context.getBean("employeeDao");
		CustomerDao customerDao = (CustomerDao) context.getBean("customerDao");

		System.out.println(" *****  Select employees using RowMapper ******");
		List<Employee> employees = empDao.findAll_query_RowMapper();
		for (Employee employee : employees) {
			System.out.println(employee.getEmpId() + " | " + employee.getName() + " | " + employee.getSalary() + " | " + employee.getDept());
		}

		System.out.println(" *****  Select customer using ResultSetExtractor() ******");
		List<Customer> customers = customerDao.findCustomerByDept_query_ResultSetExtractor("DBA");
		for (Customer customer : customers) {
			System.out.println(customer.getCust_Id() + " | " + customer.getName() + " | " + customer.getSalary() + " | " + customer.getDept());
		}

		System.out.println(" *****  Select customer using PreparedStatementCallback() ******");
		customers = customerDao.findCustomerBySalary_query_PreparedStatementCallback(1005);
		for (Customer customer : customers) {
			System.out.println(customer.getCust_Id() + " | " + customer.getName() + " | " + customer.getSalary() + " | " + customer.getDept());
		}

		System.out.println(" *****  Select customer using RowCallbackHandler() ******");
		customers = customerDao.findCustomerBySalary_query_RowCallbackHandler(1005);
		for (Customer customer : customers) {
			System.out.println(customer.getCust_Id() + " | " + customer.getName() + " | " + customer.getSalary() + " | " + customer.getDept());
		}

		System.out.println(" *****  insert customer using PreparedStatementCreator() ******");
		int cust_id = RandomUtils.nextInt(10, 100);
		customerDao.insertCustomer_PreparedStatementCreator(new Customer(cust_id, "Joseph", 10000, "VP"));

		System.out.println(customerDao.findCustomerById_queryForObject(cust_id));

		System.out.println(" *****  insert customer using PreparedStatementSetter() ******");
		cust_id = RandomUtils.nextInt(10, 100);
		customerDao.insertCustomer_PreparedStatementSetter(new Customer(cust_id, "Greg", 10000, "SVP"));

		System.out.println(customerDao.findCustomerById_queryForObject(cust_id));

		context.close();
	}
}
