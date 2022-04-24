package com.webdev.realstate.users.user.domain.exceptions;

public class FailedAuthentication extends RuntimeException {
	public FailedAuthentication(String message) {
		super(message);
	}
}
