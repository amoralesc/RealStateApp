package com.webdev.realstate.appointments.appointment.domain.valueobjects;

import com.webdev.realstate.shared.domain.aggregate.BooleanValueObject;

public class AppointmentState extends BooleanValueObject {
	public AppointmentState(Boolean value) {
		this.value = value;
	}
}
