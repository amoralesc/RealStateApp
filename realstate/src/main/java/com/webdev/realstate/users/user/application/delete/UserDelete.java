package com.webdev.realstate.users.user.application.delete;

import com.webdev.realstate.users.user.domain.User;
import com.webdev.realstate.users.user.domain.ports.UserRepository;
import com.webdev.realstate.users.user.domain.valueobjects.UserId;

import java.util.Optional;

public class UserDelete {

	private UserRepository repository;

	public UserDelete(UserRepository repository) {
		this.repository = repository;
	}

	public void execute(String id) {
		Optional<User> optionalUser = repository.findById(new UserId(id));
		optionalUser.ifPresent(
				user -> repository.delete(user)
		);
	}
}
