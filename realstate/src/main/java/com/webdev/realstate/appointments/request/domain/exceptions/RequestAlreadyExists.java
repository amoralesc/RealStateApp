package com.webdev.realstate.appointments.request.domain.exceptions;

public class RequestAlreadyExists extends RuntimeException {
	public RequestAlreadyExists(String message) {
		super(message);
	}
}