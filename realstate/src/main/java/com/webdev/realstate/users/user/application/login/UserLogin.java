package com.webdev.realstate.users.user.application.login;

import com.webdev.realstate.shared.application.TokenGeneration;
import com.webdev.realstate.shared.application.TokenGenerationResponse;
import com.webdev.realstate.users.user.domain.User;
import com.webdev.realstate.users.user.domain.exceptions.FailedAuthentication;
import com.webdev.realstate.users.user.domain.ports.UserRepository;
import com.webdev.realstate.users.user.domain.valueobjects.UserEmail;
import com.webdev.realstate.users.user.domain.valueobjects.UserPassword;

import java.util.Optional;

public class UserLogin {

	private final UserRepository repository;
	private final TokenGeneration tokenGeneration;

	public UserLogin(UserRepository repository, TokenGeneration tokenGeneration) {
		this.repository = repository;
		this.tokenGeneration = tokenGeneration;
	}

	public UserLoginResponse execute(String email, String password) {
		Optional<User> optionalUser = repository.findByEmail(new UserEmail(email));
		if (optionalUser.isEmpty()) {
			throw new FailedAuthentication("User not registered");
		}

		User user = optionalUser.get();
		user.authenticateUser(new UserEmail(email), new UserPassword(password));
		TokenGenerationResponse responseToken = this.tokenGeneration.execute(email);

		return new UserLoginResponse(email, responseToken.token());
	}
}
