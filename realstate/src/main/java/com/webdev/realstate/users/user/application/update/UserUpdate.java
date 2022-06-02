package com.webdev.realstate.users.user.application.update;

import com.webdev.realstate.users.user.domain.User;
import com.webdev.realstate.users.user.domain.entities.UserPhone;
import com.webdev.realstate.users.user.domain.ports.UserRepository;
import com.webdev.realstate.users.user.domain.valueobjects.UserEmail;
import com.webdev.realstate.users.user.domain.valueobjects.UserId;
import com.webdev.realstate.users.user.domain.valueobjects.UserName;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserUpdate {

	private final UserRepository repository;

	public UserUpdate(UserRepository repository) {
		this.repository = repository;
	}

	public void execute(String userEmail, String userName, List<HashMap<String, Object>> userPhonesSerialized) {
		Optional<User> optionalUser = repository.findByEmail(new UserEmail(userEmail));
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();

			if (userName != null && !userName.isEmpty()) {
				user.updateName(new UserName(userName));
			}
			if (userPhonesSerialized != null) {
				List<UserPhone> userPhones =
						userPhonesSerialized.stream().map(
								element -> new UserPhone(
										(String) element.get("countryCode"),
										(String) element.get("number")
								)
						).collect(Collectors.toList());
				user.updatePhones(userPhones);
			}

			repository.update(user);
		}
	}
}
