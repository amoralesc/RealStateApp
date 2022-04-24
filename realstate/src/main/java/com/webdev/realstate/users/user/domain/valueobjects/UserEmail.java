package com.webdev.realstate.users.user.domain.valueobjects;

import com.webdev.realstate.shared.domain.aggregate.StringValueObject;
import com.webdev.realstate.users.user.domain.exceptions.InvalidUserEmail;

public class UserEmail extends StringValueObject {
	public UserEmail(String value) {
		validate(value);
		this.value = value;
	}

	private void validate(String value) {
		emailFormat(value);
	}

	private void emailFormat(String value) {
		if (!value.contains("@")) {
			throw new InvalidUserEmail("Email must contain @");
		}
	}
}
