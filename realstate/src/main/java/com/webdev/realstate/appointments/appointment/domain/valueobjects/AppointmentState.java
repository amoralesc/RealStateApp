package com.webdev.realstate.appointments.appointment.domain.valueobjects;

import com.webdev.realstate.shared.domain.aggregate.StringValueObject;

public class AppointmentState extends StringValueObject {
	public AppointmentState(String value) {
		this.value = value;
	}

	// Check if it's
	// PENDING
	// DONE
	// CANCELLED
}
