package in.spring4buddies.application.dao;

import in.spring4buddies.application.model.Customer;

import java.util.List;

public interface CustomerDao {

	Customer findByCustomerId(long customerId);

	List<Customer> findAllCustomers();

	void saveCustomer(Customer customer);

	void updateCustomer(Customer customer);

	void deleteCustomer(long customerId);

}