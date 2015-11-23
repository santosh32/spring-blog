package in.spring4buddies.application.annotation.autowired;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CustomerDao {

	public Customer getCustomerById(Integer Id) {
		System.out.println("CustomerDao: Method getCustomerById() called");
		return new Customer();
	}

	public List<Customer> getAllCustomer() {
		System.out.println("CustomerDao: Method getAllCustomer() called");
		Customer customer =new Customer();
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(customer);
		return customers;
	}

	public void createCustomer(Customer Customer) {
		System.out.println("CustomerDao: Method createCustomer() called");
	}

	public void deleteCustomer(Integer CustomerId) {
		System.out.println("CustomerDao: Method deleteCustomer() called");
	}

	public void updateCustomer(Customer Customer) {
		System.out.println("CustomerDao: Method updateCustomer() called");
	}
}
