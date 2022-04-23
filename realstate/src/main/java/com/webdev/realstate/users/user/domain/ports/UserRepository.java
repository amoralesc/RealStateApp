package com.webdev.realstate.users.user.domain.ports;

import com.webdev.realstate.users.user.domain.User;
import com.webdev.realstate.users.user.domain.valueobjects.UserEmail;
import com.webdev.realstate.users.user.domain.valueobjects.UserId;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
	void save(User user);
	void update(User user);
	void delete(User user);
	Optional<User> find(UserId userId);
	Optional<User> findByEmail(UserEmail email);
	Optional<List<User>> findAll();
}
