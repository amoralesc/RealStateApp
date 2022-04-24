package com.webdev.realstate.users.user.application.add;

import com.webdev.realstate.users.user.domain.User;
import com.webdev.realstate.users.user.domain.entities.UserPhone;
import com.webdev.realstate.users.user.domain.ports.UserRepository;
import com.webdev.realstate.users.user.domain.valueobjects.UserId;

import java.util.Optional;

public class UserAddPhone {

	private UserRepository repository;

	public UserAddPhone(UserRepository repository) {
		this.repository = repository;
	}

	public void execute(String userId, String countryCode, String phoneNumber) {
		Optional<User> optionalUser = repository.findById(new UserId(userId));
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			user.addPhone(
					new UserPhone(
							countryCode,
							phoneNumber
					));
			repository.update(user);
		}
	}
}
