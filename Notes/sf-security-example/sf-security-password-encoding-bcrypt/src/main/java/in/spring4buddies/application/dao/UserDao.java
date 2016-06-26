package in.spring4buddies.application.dao;

import in.spring4buddies.application.model.User;

public interface UserDao {

	void save(User user);

	User findById(int id);

	User findBySSO(String sso);
}
