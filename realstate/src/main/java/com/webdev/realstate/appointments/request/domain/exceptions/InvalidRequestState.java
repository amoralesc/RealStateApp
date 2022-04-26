package com.webdev.realstate.appointments.request.domain.exceptions;

public class InvalidRequestState extends RuntimeException {

	public InvalidRequestState(String message) {
		super(message);
	}
}
