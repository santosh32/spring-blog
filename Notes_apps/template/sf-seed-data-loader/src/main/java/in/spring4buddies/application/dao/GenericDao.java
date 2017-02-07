package in.spring4buddies.application.dao;

import java.util.List;

public interface GenericDao<T> {

	void insert(List<T> data, Class<T> clazz);

	List<T> getAll(Class<T> clazz);
}
