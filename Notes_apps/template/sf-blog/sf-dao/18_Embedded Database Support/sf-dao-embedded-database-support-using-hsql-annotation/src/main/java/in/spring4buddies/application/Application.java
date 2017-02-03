package in.spring4buddies.application;

import in.spring4buddies.application.model.Address;
import in.spring4buddies.application.model.Customer;
import in.spring4buddies.application.service.CustomerService;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String args[]) {

		String confFile = "beans.xml";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(confFile);

		CustomerService customerService = context.getBean(CustomerService.class);

		System.out.println("Customer information with Customer Id = 2");
		Customer findCustomer = customerService.findByCustomerId(2);
		System.out.println(findCustomer);

		System.out.println();
		System.out.println("List all Customers");

		List<Customer> customers = customerService.findAllCustomers();
		for (Customer customer : customers) {
			System.out.println(customer);
		}

		System.out.println();
		System.out.println("Add new Customer");
		Customer customer = new Customer();
		customer.setName("Soumitra Roy");
		Address address = new Address();
		address.setLine1("Tiruvanmiyur");
		address.setCity("Chennai");
		address.setState("Tamil Nadu");
		address.setZipCd("600020");
		customer.setAddress(address);
		customerService.saveCustomer(customer);

		System.out.println();
		System.out.println("New customer information");

		Customer cust = customerService.findByCustomerId(6);
		System.out.println(cust);

		System.out.println();
		System.out.println("After creating a new Customer, list all Customers");

		List<Customer> customersAfterAddition = customerService.findAllCustomers();
		for (Customer customerAdd : customersAfterAddition) {
			System.out.println(customerAdd);
		}

		System.out.println();
		System.out.println("Update customer information for Customer Id = 6");

		Customer customerUpdate = customerService.findByCustomerId(6);
		customerUpdate.getAddress().setLine1("Chingrihata");
		customerUpdate.getAddress().setCity("Kolkata");
		customerUpdate.getAddress().setState("West Bengal");
		customerUpdate.getAddress().setZipCd("700105");
		customerService.updateCustomer(customerUpdate);

		System.out.println();
		System.out.println("After updating customer information for Customer Id = 6");

		Customer custUpdate = customerService.findByCustomerId(6);
		System.out.println(custUpdate);

		System.out.println();
		System.out.println("Delete customer information for Customer Id = 6");
		customerService.deleteCustomer(6);

		System.out.println();
		System.out.println("After deleting a Customer for Customer Id = 6, list all Customers");

		List<Customer> customersAfterDeletion = customerService.findAllCustomers();
		for (Customer customerDel : customersAfterDeletion) {
			System.out.println(customerDel);
		}

		context.close();
	}
}
