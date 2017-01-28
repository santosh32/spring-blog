package in.spring4buddies.application;

import in.spring4buddies.application.dao.CustomerDao;
import in.spring4buddies.application.dao.EmployeeDao;
import in.spring4buddies.application.model.Customer;
import in.spring4buddies.application.model.Employee;

import java.util.List;

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

		context.close();
	}
}
