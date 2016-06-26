package in.spring4buddies.application.service;

import in.spring4buddies.application.model.User;

public interface UserService {

	void save(User user);

	User findById(int id);

	User findBySso(String sso);
}