package com.webdev.realstate.appointments.appointment.domain.valueobjects;

import com.webdev.realstate.shared.domain.aggregate.BooleanValueObject;

public class AppointmentIsRequest extends BooleanValueObject {
	public AppointmentIsRequest(Boolean value) {
		this.value = value;
	}
}
