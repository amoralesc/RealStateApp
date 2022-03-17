package com.webdev.realstate.users.user.domain.exceptions;

public class AuthenticateFailed extends RuntimeException {
	public AuthenticateFailed(String message) {
		super(message);
	}
}
