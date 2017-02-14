package in.spring4buddies.application.dao;

import in.spring4buddies.application.model.Customer;
import in.spring4buddies.application.model.Employee;
import in.spring4buddies.application.model.Invoice;
import in.spring4buddies.application.model.Order;
import in.spring4buddies.application.model.Staff;

import java.util.List;

public interface CommonDao {

	int[] insertStaff(List<Staff> staffs);

	int[] insertCustomer(List<Customer> customers);

	int[] insertEmployee(List<Employee> employees);

	int[][] insertInvoice(List<Invoice> invoices);

	int[] insertOrder(List<Order> orders);
}