package com.webdev.realstate.users.user.domain.exceptions;

public class InvalidUserEmail extends RuntimeException {
	public InvalidUserEmail(String message) {
		super(message);
	}
}
