package in.spring4buddies.application.service;

import in.spring4buddies.application.dao.UserProfileDao;
import in.spring4buddies.application.model.UserProfile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

	@Autowired
	UserProfileDao dao;

	public List<UserProfile> findAll() {
		return dao.findAll();
	}

	public UserProfile findByType(String type) {
		return dao.findByType(type);
	}

	public UserProfile findById(int id) {
		return dao.findById(id);
	}
}
