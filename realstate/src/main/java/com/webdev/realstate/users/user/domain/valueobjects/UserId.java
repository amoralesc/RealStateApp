package com.webdev.realstate.users.user.domain.valueobjects;

import com.webdev.realstate.shared.domain.aggregate.CustomUUID;

public class UserId extends CustomUUID {
	private UserId() {}

	public UserId(String value) {
		super(value);
	}
}
