package com.webdev.realstate.users.user.domain.valueobjects;

import com.webdev.realstate.shared.domain.aggregate.StringValueObject;
import com.webdev.realstate.users.user.domain.exceptions.InvalidPassword;

public class UserPassword extends StringValueObject {
	public UserPassword(String value) {
		validate(value);
		this.value = value;
	}

	private void validate(String value) {
		this.symbolContains(value);
	}

	private void symbolContains(String value) {
		if (!(value.contains("$") || value.contains("*"))) {
			throw new InvalidPassword("Símbolo no encontrado en la contraseña");
		}
	}
}
