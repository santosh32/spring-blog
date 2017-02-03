package in.spring4buddies.application.service;

import in.spring4buddies.application.dao.CustomerDao;
import in.spring4buddies.application.model.Customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public Customer findByCustomerId(long customerId) {
		return customerDao.findByCustomerId(customerId);
	}

	@Override
	public List<Customer> findAllCustomers() {
		return customerDao.findAllCustomers();
	}

	@Override
	public void saveCustomer(Customer customer) {
		customerDao.saveCustomer(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);
	}

	@Override
	public void deleteCustomer(long customerId) {
		customerDao.deleteCustomer(customerId);
	}
}