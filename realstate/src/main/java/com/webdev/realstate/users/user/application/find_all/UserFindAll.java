package com.webdev.realstate.users.user.application.find_all;

import com.webdev.realstate.users.user.domain.User;
import com.webdev.realstate.users.user.domain.ports.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserFindAll {

	private UserRepository repository;

	public UserFindAll(UserRepository repository) {
		this.repository = repository;
	}

	public List<User> execute() {
		List<User> users = new ArrayList<>();
		Optional<List<User>> optionalUsers = repository.findAll();
		if (optionalUsers.isPresent()) {
			users = optionalUsers.get();
		}
		return users;
	}
}
