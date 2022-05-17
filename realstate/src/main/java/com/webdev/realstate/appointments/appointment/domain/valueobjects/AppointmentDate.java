package com.webdev.realstate.appointments.appointment.domain.valueobjects;

import com.webdev.realstate.appointments.appointment.domain.exceptions.InvalidDate;
import com.webdev.realstate.shared.domain.aggregate.DateValueObject;

import java.util.Date;

public class AppointmentDate extends DateValueObject {

	public AppointmentDate() {
	}

	public AppointmentDate(Date value) {
		validate(value);
		this.value = value;
	}

	private void validate(Date value) {
		dateIsNotInThePast(value);
	}

	private void dateIsNotInThePast(Date value) {
		// Check if date is not less than current date
		if (value.before(new Date())) {
			throw new InvalidDate("Date cannot be in the past");
		}
	}
}
