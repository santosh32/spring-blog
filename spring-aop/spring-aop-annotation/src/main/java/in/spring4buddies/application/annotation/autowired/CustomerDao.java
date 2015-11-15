package in.spring4buddies.application.annotation.autowired;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CustomerDao {

	public Customer getCustomerById(Integer Id) {
		System.out.println("Method getCustomerById() called");
		return new Customer();
	}

	public List<Customer> getAllCustomer() {
		System.out.println("Method getAllCustomer() called");
		return new ArrayList<Customer>();
	}

	public void createCustomer(Customer Customer) {
		System.out.println("Method createCustomer() called");
	}

	public void deleteCustomer(Integer CustomerId) {
		System.out.println("Method deleteCustomer() called");
	}

	public void updateCustomer(Customer Customer) {
		System.out.println("Method updateCustomer() called");
	}
}
