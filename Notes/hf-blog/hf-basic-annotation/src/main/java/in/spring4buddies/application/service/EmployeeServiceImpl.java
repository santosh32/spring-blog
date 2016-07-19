package in.spring4buddies.application.service;

import java.util.List;

import in.spring4buddies.application.dao.EmployeeDao;
import in.spring4buddies.application.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public void saveEmployee(Employee employee) {
		employeeDao.save(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeDao.update(employee);
	}

	@Override
	public void deleteEmployeeBySsn(String ssn) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Employee> findAllEmployees() {
		return employeeDao.findAllEmployees();
	}
}
