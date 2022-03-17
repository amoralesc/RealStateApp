package com.webdev.realstate.appointments.appointment.domain;

import com.webdev.realstate.appointments.appointment.domain.valueobjects.*;

import java.util.HashMap;

public class Appointment {
	AppointmentId appointmentId;
	AppointmentDate appointmentDate;
	AppointmentState appointmentState;
	AppointmentIsRequest appointmentIsRequest;

	public Appointment(AppointmentId appointmentId, AppointmentDate appointmentDate, AppointmentState appointmentState, AppointmentIsRequest appointmentIsRequest) {
		this.appointmentId = appointmentId;
		this.appointmentDate = appointmentDate;
		this.appointmentState = appointmentState;
		this.appointmentIsRequest = appointmentIsRequest;
	}

	public static Appointment create(AppointmentId appointmentId, AppointmentDate appointmentDate) {
		Appointment appointment = new Appointment(appointmentId, appointmentDate, new AppointmentState(true), new AppointmentIsRequest(true));
		return appointment;
	}

	public HashMap<String, Object> data() {
		HashMap<String, Object> data = new HashMap<>() {{
			put("id", appointmentId.value());
			put("date", appointmentDate.value());
			put("state", appointmentState.value());
			put("isRequest", appointmentIsRequest.value());
		}};
		return data;
	}
}
