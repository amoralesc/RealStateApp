package com.webdev.realstate.users.user.application.add;

import com.webdev.realstate.users.user.domain.User;
import com.webdev.realstate.users.user.domain.entities.UserRequest;
import com.webdev.realstate.users.user.domain.ports.UserRepository;
import com.webdev.realstate.users.user.domain.valueobjects.UserId;

import java.util.Date;
import java.util.Optional;

public class UserAddRequest {

	private UserRepository repository;

	public UserAddRequest(UserRepository repository) {
		this.repository = repository;
	}

	public void execute(String userId, Date date, String state, String propertyId, String agentId) {
		Optional<User> optionalUser = repository.findById(new UserId(userId));
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			user.addRequest(
					new UserRequest(
							userId,
							date,
							state,
							propertyId,
							agentId
					));
			repository.update(user);
		}
	}
}