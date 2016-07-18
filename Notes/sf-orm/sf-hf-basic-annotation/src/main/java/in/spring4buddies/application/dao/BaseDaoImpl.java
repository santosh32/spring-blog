package in.spring4buddies.application.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository("baseDao")
public class BaseDaoImpl<T> implements BaseDao<T> {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void persist(T t) {
		getSession().persist(t);
	}

	@Override
	public Serializable save(T t) {
		return getSession().save(t);
	}

	@Override
	public void update(T t) {
		getSession().update(t);
	}

	@Override
	public void saveOrUpdate(T t) {
		getSession().saveOrUpdate(t);
	}

	@Override
	public T merge(T t) {
		return (T) getSession().merge(t);
	}

	@Override
	public void delete(T t) {
		getSession().delete(t);
	}

//	@Override
//	public List<T> findAll(T t) {
//		getSession().createCriteria(T.class);
//		return (List<T>) criteria.list();
//	}
}
