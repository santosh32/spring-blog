package in.spring4buddies.application.dao;

import in.spring4buddies.application.model.UserProfile;

import java.util.List;

public interface UserProfileDao {

	List<UserProfile> findAll();

	UserProfile findByType(String type);

	UserProfile findById(int id);
}
