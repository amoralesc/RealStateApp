package com.webdev.realstate.appointments.appointment.domain;

import com.webdev.realstate.appointments.appointment.domain.valueobjects.AppointmentDate;
import com.webdev.realstate.appointments.appointment.domain.valueobjects.AppointmentId;
import com.webdev.realstate.appointments.appointment.domain.valueobjects.AppointmentState;
import com.webdev.realstate.shared.domain.aggregate.AggregateRoot;
import com.webdev.realstate.users.user.domain.valueobjects.UserId;

import java.util.HashMap;

public class Appointment extends AggregateRoot {
	AppointmentId appointmentId;
	AppointmentDate appointmentDate;
	AppointmentState appointmentState;
	UserId userId;
	UserId agentId;

	public Appointment(
			AppointmentId appointmentId, AppointmentDate appointmentDate, AppointmentState appointmentState,
			UserId userId, UserId agentId
	) {
		this.appointmentId = appointmentId;
		this.appointmentDate = appointmentDate;
		this.appointmentState = appointmentState;
		this.userId = userId;
		this.agentId = agentId;
	}

	public static Appointment create(
			AppointmentId appointmentId, AppointmentDate appointmentDate, UserId userId, UserId agentId
	) {
		return new Appointment(
				appointmentId,
				appointmentDate,
				new AppointmentState("PENDING"),
				userId,
				agentId
		);
	}

	public HashMap<String, Object> data() {
		return new HashMap<>() {{
			put("id", appointmentId.value());
			put("date", appointmentDate.value());
			put("state", appointmentState.value());
			put("userId", userId.value());
			put("agentId", agentId.value());
		}};
	}
}
