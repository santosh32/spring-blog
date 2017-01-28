package in.spring4buddies.application;

import in.spring4buddies.application.dao.CustomerDao;
import in.spring4buddies.application.dao.EmployeeDao;
import in.spring4buddies.application.model.Customer;
import in.spring4buddies.application.model.Employee;

import java.util.List;

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
		
		context.close();
	}
}
