package com.webdev.realstate.users.user.domain.valueobjects;

import com.webdev.realstate.shared.domain.aggregate.StringValueObject;
import com.webdev.realstate.users.user.domain.exceptions.InvalidLength;

public class UserName extends StringValueObject {

	public UserName() {
	}

	public UserName(String value) {
		validate(value);
		this.value = value;
	}

	private void validate(String value) {
		lengthValue(value);
	}

	private void lengthValue(String value) {
		if (value.length() < 5 || value.length() > 30) {
			throw new InvalidLength("Name must be between 5 and 30 characters");
		}
	}
}
