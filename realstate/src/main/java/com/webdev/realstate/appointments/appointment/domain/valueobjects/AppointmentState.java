package com.webdev.realstate.appointments.appointment.domain.valueobjects;

import com.webdev.realstate.appointments.appointment.domain.exceptions.InvalidAppointmentState;
import com.webdev.realstate.shared.domain.aggregate.StringValueObject;

public class AppointmentState extends StringValueObject {

	public AppointmentState() {
	}

	public AppointmentState(String value) {
		validate(value);
		this.value = value;
	}

	private void validate(String value) {
		stateValue(value);
	}

	public void stateValue(String value) {
		if (!value.equals("PENDING") && !value.equals("DONE") && !value.equals("CANCELLED")) {
			throw new InvalidAppointmentState("Appointment state must be: PENDING, DONE or CANCELLED");
		}
	}
}
