package com.webdev.realstate.users.user.domain.ports;

import com.webdev.realstate.users.user.domain.User;
import com.webdev.realstate.users.user.domain.valueobjects.UserEmail;
import com.webdev.realstate.users.user.domain.valueobjects.UserId;
import com.webdev.realstate.users.user.domain.valueobjects.UserName;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
	void save(User user);
	void update(User user);
	void delete(User user);
	Optional<User> findById(UserId userId);
	Optional<User> findByEmail(UserEmail email);
	Optional<User> findByUsername(UserName username);
	Optional<List<User>> findAll();
}
