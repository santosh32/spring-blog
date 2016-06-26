package in.spring4buddies.application.service;

import in.spring4buddies.application.model.UserProfile;

import java.util.List;

public interface UserProfileService {

	List<UserProfile> findAll();

	UserProfile findByType(String type);

	UserProfile findById(int id);
}
