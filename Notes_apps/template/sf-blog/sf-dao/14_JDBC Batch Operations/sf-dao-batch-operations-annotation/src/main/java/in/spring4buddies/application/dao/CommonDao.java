package in.spring4buddies.application.dao;

import in.spring4buddies.application.model.Employee;
import in.spring4buddies.application.model.Invoice;
import in.spring4buddies.application.model.Order;

import java.util.List;

public interface CommonDao {

	void insertEmployee(List<Employee> employees);

	void insertInvoice(List<Invoice> invoices);

	void insertOrder(List<Order> orders);

}