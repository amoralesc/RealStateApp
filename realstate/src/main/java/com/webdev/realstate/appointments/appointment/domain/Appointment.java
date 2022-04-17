package com.webdev.realstate.appointments.appointment.domain;

import com.webdev.realstate.appointments.appointment.domain.valueobjects.*;

import java.util.HashMap;

public class Appointment {
	AppointmentId appointmentId;
	AppointmentDate appointmentDate;
	AppointmentState appointmentState;

	public Appointment(
			AppointmentId appointmentId, AppointmentDate appointmentDate, AppointmentState appointmentState
	) {
		this.appointmentId = appointmentId;
		this.appointmentDate = appointmentDate;
		this.appointmentState = appointmentState;
	}

	public static Appointment create(
			AppointmentId appointmentId, AppointmentDate appointmentDate
	) {
		Appointment appointment = new Appointment(
				appointmentId,
				appointmentDate,
				new AppointmentState("PENDING")
		);
		return appointment;
	}

	public HashMap<String, Object> data() {
		HashMap<String, Object> data = new HashMap<>() {{
			put("id", appointmentId.value());
			put("date", appointmentDate.value());
			put("state", appointmentState.value());
		}};
		return data;
	}
}
