package in.spring4buddies.application.dao;

import in.spring4buddies.application.model.Customer;

import java.util.List;

public interface CustomerDao {

	void insertCustomer(Customer customer);

	void updateCustomer(Customer customer);

	void removeCustomer(int custId);

	Customer findCustomerById(int custId);

	List<Customer> findAll();

}
