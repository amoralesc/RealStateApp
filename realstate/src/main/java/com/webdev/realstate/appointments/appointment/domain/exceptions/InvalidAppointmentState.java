package com.webdev.realstate.appointments.appointment.domain.exceptions;

public class InvalidAppointmentState extends RuntimeException {

	public InvalidAppointmentState(String message) {
		super(message);
	}
}
