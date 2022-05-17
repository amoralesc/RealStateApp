package com.webdev.realstate.users.user.domain.valueobjects;

import com.webdev.realstate.shared.domain.aggregate.StringValueObject;
import com.webdev.realstate.users.user.domain.exceptions.InvalidLength;
import com.webdev.realstate.users.user.domain.exceptions.InvalidPassword;

public class UserPassword extends StringValueObject {

	public UserPassword() {
	}

	public UserPassword(String value) {
		validate(value);
		this.value = value;
	}

	private void validate(String value) {
		this.lengthValue(value);
	}

	private void lengthValue(String value) {
		if (value.length() < 8) {
			throw new InvalidLength(
					"The password must be at least 8 characters long");
		}
	}
}
