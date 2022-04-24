package com.webdev.realstate.users.user.application.create;

import com.webdev.realstate.users.user.domain.User;
import com.webdev.realstate.users.user.domain.ports.UserRepository;
import com.webdev.realstate.users.user.domain.valueobjects.UserEmail;
import com.webdev.realstate.users.user.domain.valueobjects.UserId;
import com.webdev.realstate.users.user.domain.valueobjects.UserName;
import com.webdev.realstate.users.user.domain.valueobjects.UserPassword;

public class UserCreator {

	private UserRepository repository;

	public UserCreator(UserRepository repository) {
		this.repository = repository;
	}

	public void execute(String userId, String userName, String userEmail, String password
	) {
		User user = User.create(
				new UserId(userId),
				new UserName(userName),
				new UserEmail(userEmail),
				new UserPassword(password)
		);
		repository.save(user);
	}
}
