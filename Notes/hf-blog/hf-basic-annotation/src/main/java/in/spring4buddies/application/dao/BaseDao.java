package in.spring4buddies.application.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

public interface BaseDao<T> {

	Session getSession();
	Serializable save(T t);

	void persist(T t);

	void update(T t);

	void saveOrUpdate(T t);

	T merge(T t);

	void delete(T t);

	List<T> findAll();
	
	
}
