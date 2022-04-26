package com.webdev.realstate.users.user.application.update;

import com.webdev.realstate.users.user.domain.User;
import com.webdev.realstate.users.user.domain.entities.UserRequest;
import com.webdev.realstate.users.user.domain.ports.UserRepository;
import com.webdev.realstate.users.user.domain.valueobjects.UserId;

import java.util.Date;
import java.util.Optional;

public class UserUpdateRequest {

	private final UserRepository repository;

	public UserUpdateRequest(UserRepository repository) {
		this.repository = repository;
	}

	public void execute(String id, Date date, String state, String propertyId, String userId, String agentId) {
		// Update appointment to user
		Optional<User> optionalUser =
				repository.findById(new UserId(userId));

		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			user.updateRequest(
					new UserRequest(
							id,
							date,
							state,
							propertyId,
							userId,
							agentId
					)
			);
			repository.update(user);
		}

		// Update appointment to agent
		Optional<User> optionalAgent =
				repository.findById(new UserId(agentId));

		if (optionalAgent.isPresent()) {
			User agent = optionalAgent.get();
			agent.updateRequest(
					new UserRequest(
							id,
							date,
							state,
							propertyId,
							userId,
							agentId
					)
			);
			repository.update(agent);
		}
	}
}
