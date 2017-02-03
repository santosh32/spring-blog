package in.spring4buddies.application.service;

import in.spring4buddies.application.model.Customer;

import java.util.List;

public interface CustomerService {

	Customer findByCustomerId(long customerId);

	List<Customer> findAllCustomers();

	void saveCustomer(Customer customer);

	void updateCustomer(Customer customer);

	void deleteCustomer(long customerId);

}