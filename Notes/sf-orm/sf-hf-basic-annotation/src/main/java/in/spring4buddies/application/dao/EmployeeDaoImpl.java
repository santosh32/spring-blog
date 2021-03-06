package in.spring4buddies.application.dao;

import in.spring4buddies.application.model.Employee;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

@Repository("employeeDao")
public class EmployeeDaoImpl extends BaseDaoImpl<Employee> implements EmployeeDao {

	 @SuppressWarnings("unchecked")
	 public List<Employee> findAllEmployees() {
	 Criteria criteria = getSession().createCriteria(Employee.class);
	 return (List<Employee>) criteria.list();
	 }

	// public void deleteEmployeeBySsn(String ssn) {
	// Query query =
	// getSession().createSQLQuery("delete from Employee where ssn = :ssn");
	// query.setString("ssn", ssn);
	// query.executeUpdate();
	// }

	// public Employee findBySsn(String ssn) {
	// Criteria criteria = getSession().createCriteria(Employee.class);
	// criteria.add(Restrictions.eq("ssn", ssn));
	// return (Employee) criteria.uniqueResult();
	// }

	// @Override
	// public List<Employee> findAll() {
	// // TODO Auto-generated method stub
	// return null;
	// }

}
