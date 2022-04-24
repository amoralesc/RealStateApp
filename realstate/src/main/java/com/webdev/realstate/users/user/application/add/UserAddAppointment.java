package com.webdev.realstate.users.user.application.add;

import com.webdev.realstate.users.user.domain.User;
import com.webdev.realstate.users.user.domain.entities.UserAppointment;
import com.webdev.realstate.users.user.domain.entities.UserRequest;
import com.webdev.realstate.users.user.domain.ports.UserRepository;
import com.webdev.realstate.users.user.domain.valueobjects.UserId;

import java.util.Date;
import java.util.Optional;

public class UserAddAppointment {

	private UserRepository repository;

	public UserAddAppointment(UserRepository repository) {
		this.repository = repository;
	}

	public void execute(String id, Date date, String state, String propertyId, String userId, String agentId) {
		Optional<User> optionalUser = repository.findById(new UserId(userId));
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			user.addAppointment(
					new UserAppointment(
							id,
							date,
							state,
							propertyId,
							userId,
							agentId
					));
			repository.update(user);
		}
	}
}
