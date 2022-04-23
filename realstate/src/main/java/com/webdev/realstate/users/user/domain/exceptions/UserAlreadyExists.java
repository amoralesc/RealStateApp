package com.webdev.realstate.users.user.domain.exceptions;

public class UserAlreadyExists extends RuntimeException {
	public UserAlreadyExists(String message) {
		super(message);
	}
}
