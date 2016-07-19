package in.spring4buddies.application.dao;

import java.util.List;

import in.spring4buddies.application.model.Employee;

public interface EmployeeDao extends BaseDao<Employee> {
	List<Employee> findAllEmployees();
}
