package com.webdev.realstate.users.user.application.find;

import com.webdev.realstate.users.user.domain.User;
import com.webdev.realstate.users.user.domain.ports.UserRepository;
import com.webdev.realstate.users.user.domain.valueobjects.UserId;

import java.util.Optional;

public class UserFindById {

	private final UserRepository repository;

	public UserFindById(UserRepository repository) {
		this.repository = repository;
	}

	public User execute(String id) {
		User user = null;
		Optional<User> optionalUser = repository.findById(new UserId(id));
		if (optionalUser.isPresent()) {
			user = optionalUser.get();
		}
		return user;
	}
}
