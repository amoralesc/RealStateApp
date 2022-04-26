package com.webdev.realstate.appointments.appointment.application.find_all;

import com.webdev.realstate.appointments.appointment.domain.Appointment;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class AppointmentFindAllResponse {

	private List<Appointment> appointments;

	public AppointmentFindAllResponse(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public List<HashMap<String, Object>> response() {
		return appointments.stream().map(
				appointment -> appointment.data()
		).collect(Collectors.toList());
	}
}
