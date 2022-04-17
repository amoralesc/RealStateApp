package com.webdev.realstate.shared.domain.exceptions;

public class UnauthorizedAction extends RuntimeException {
	public UnauthorizedAction(String message) {
		super(message);
	}
}
