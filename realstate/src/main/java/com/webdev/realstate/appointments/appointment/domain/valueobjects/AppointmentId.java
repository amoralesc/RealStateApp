package com.webdev.realstate.appointments.appointment.domain.valueobjects;

import com.webdev.realstate.shared.domain.aggregate.CustomUUID;

public class AppointmentId extends CustomUUID {

	public AppointmentId() {
	}

	public AppointmentId(String value) {
		super(value);
	}
}
