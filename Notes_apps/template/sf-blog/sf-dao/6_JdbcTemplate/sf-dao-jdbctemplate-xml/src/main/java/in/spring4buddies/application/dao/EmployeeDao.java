package in.spring4buddies.application.dao;

import in.spring4buddies.application.model.Employee;

public interface EmployeeDao {

	void insertEmployee(Employee emp);

	void updateEmployee(Employee emp);

	void removeEmployee(int empId);

	Employee findEmployeeById(int empId);

}
