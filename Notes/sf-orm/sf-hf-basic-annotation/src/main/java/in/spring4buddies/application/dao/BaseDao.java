package in.spring4buddies.application.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {

	public Serializable save(T t);

	public void persist(T t);

	public void update(T t);

	public void saveOrUpdate(T t);

	public T merge(T t);

	public void delete(T t);
	
//	public List<T> findAll();
}
