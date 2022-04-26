package com.webdev.realstate.appointments.appointment.domain.exceptions;

public class AppointmentAlreadyExists extends RuntimeException {

	public AppointmentAlreadyExists(String message) {
		super(message);
	}
}
