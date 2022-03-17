package com.webdev.realstate.users.user.domain.valueobjects;

import com.webdev.realstate.shared.domain.aggregate.BooleanValueObject;

public class UserIsAgent extends BooleanValueObject {
	public UserIsAgent(Boolean value) {
		this.value = value;
	}
}
