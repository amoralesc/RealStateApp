package com.webdev.realstate.appointments.appointment.application.find;

import com.webdev.realstate.appointments.appointment.domain.Appointment;

import java.util.HashMap;

public class AppointmentFindByIdResponse {

	private Appointment appointment;

	public AppointmentFindByIdResponse(Appointment appointment) {
		this.appointment = appointment;
	}

	public HashMap<String, Object> response() {
		if (appointment == null) {
			return new HashMap<>();
		}

		return appointment.data();
	}
}
