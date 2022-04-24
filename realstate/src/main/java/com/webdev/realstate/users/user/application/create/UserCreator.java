package com.webdev.realstate.users.user.application.create;

import com.webdev.realstate.users.user.domain.User;
import com.webdev.realstate.users.user.domain.ports.UserRepository;
import com.webdev.realstate.users.user.domain.valueobjects.*;

public class UserCreator {

	private UserRepository repository;

	public UserCreator(UserRepository repository) {
		this.repository = repository;
	}

	public void execute(
			String userId, String userName, String userEmail,
			String password, Boolean isAgent
	) {
		User user = User.create(
				new UserId(userId),
				new UserName(userName),
				new UserEmail(userEmail),
				new UserPassword(password),
				new UserIsAgent(isAgent)
		);
		repository.save(user);
	}
}
