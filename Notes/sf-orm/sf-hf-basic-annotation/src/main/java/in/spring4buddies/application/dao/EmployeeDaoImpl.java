package in.spring4buddies.application.dao;

import in.spring4buddies.application.model.Employee;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao  {

	@Autowired
	private BaseDao<Employee> baseDao;

//	@SuppressWarnings("unchecked")
//	public List<Employee> findAllEmployees() {
//		Criteria criteria = getSession().createCriteria(Employee.class);
//		return (List<Employee>) criteria.list();
//	}

//	public void deleteEmployeeBySsn(String ssn) {
//		Query query = getSession().createSQLQuery("delete from Employee where ssn = :ssn");
//		query.setString("ssn", ssn);
//		query.executeUpdate();
//	}

//	public Employee findBySsn(String ssn) {
//		Criteria criteria = getSession().createCriteria(Employee.class);
//		criteria.add(Restrictions.eq("ssn", ssn));
//		return (Employee) criteria.uniqueResult();
//	}

	@Override
	public Serializable save(Employee t) {
		return baseDao.save(t);
	}

	@Override
	public void persist(Employee t) {
		baseDao.persist(t);
	}

	@Override
	public void update(Employee t) {
		baseDao.update(t);
	}

	@Override
	public void saveOrUpdate(Employee t) {
		baseDao.saveOrUpdate(t);
	}

	@Override
	public Employee merge(Employee t) {
		return baseDao.merge(t);
	}

	@Override
	public void delete(Employee t) {
		baseDao.delete(t);
	}

//	@Override
//	public List<Employee> findAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
