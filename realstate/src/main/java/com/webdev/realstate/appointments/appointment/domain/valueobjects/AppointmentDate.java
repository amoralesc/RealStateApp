package com.webdev.realstate.appointments.appointment.domain.valueobjects;

import com.webdev.realstate.shared.domain.aggregate.DateValueObject;

import java.util.Date;

public class AppointmentDate extends DateValueObject {
	public AppointmentDate(Date value) {
		this.value = value;
	}
}
