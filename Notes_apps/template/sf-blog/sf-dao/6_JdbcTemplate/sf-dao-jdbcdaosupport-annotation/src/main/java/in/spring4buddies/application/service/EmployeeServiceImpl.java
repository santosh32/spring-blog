package in.spring4buddies.application.service;

import in.spring4buddies.application.dao.EmployeeDao;
import in.spring4buddies.application.model.Employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	@Override
	public void insertEmployee(Employee emp) {
		employeeDao.insertEmployee(emp);
	}

	@Override
	public void updateEmployee(Employee emp) {
		employeeDao.updateEmployee(emp);
	}

	@Override
	public void removeEmployee(int empId) {
		employeeDao.removeEmployee(empId);
	}

	@Override
	public Employee findEmployeeById(int empId) {
		return employeeDao.findEmployeeById(empId);
	}

	@Override
	public List<Employee> findAll_query_RowMapper() {
		return employeeDao.findAll_query_RowMapper();
	}
}
