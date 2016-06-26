package in.spring4buddies.application.service;

import in.spring4buddies.application.model.User;

import java.util.List;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;

public interface UserService {

	List<User> findAllUsers();

	@PostAuthorize("returnObject.type == authentication.name")
	User findById(int id);

	@PreAuthorize("hasRole('ADMIN')")
	void updateUser(User user);

	@PreAuthorize("hasRole('ADMIN') AND hasRole('DBA')")
	void deleteUser(int id);
}