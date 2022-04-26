package com.webdev.realstate.appointments.appointment.domain;

import com.webdev.realstate.appointments.appointment.domain.events.AppointmentCreatedDomainEvent;
import com.webdev.realstate.appointments.appointment.domain.events.AppointmentUpdatedDomainEvent;
import com.webdev.realstate.appointments.appointment.domain.valueobjects.AppointmentDate;
import com.webdev.realstate.appointments.appointment.domain.valueobjects.AppointmentId;
import com.webdev.realstate.appointments.appointment.domain.valueobjects.AppointmentState;
import com.webdev.realstate.properties.property.domain.valueobjects.PropertyId;
import com.webdev.realstate.shared.domain.aggregate.AggregateRoot;
import com.webdev.realstate.users.user.domain.valueobjects.UserId;

import java.util.HashMap;

public class Appointment extends AggregateRoot {
	AppointmentId appointmentId;
	AppointmentDate appointmentDate;
	AppointmentState appointmentState;
	PropertyId propertyId;
	UserId userId;
	UserId agentId;

	public Appointment(
			AppointmentId appointmentId, AppointmentDate appointmentDate, AppointmentState appointmentState, PropertyId propertyId,
			UserId userId, UserId agentId
	) {
		this.appointmentId = appointmentId;
		this.appointmentDate = appointmentDate;
		this.appointmentState = appointmentState;
		this.propertyId = propertyId;
		this.userId = userId;
		this.agentId = agentId;
	}

	public static Appointment create(
			AppointmentId appointmentId, AppointmentDate appointmentDate, PropertyId propertyId, UserId userId, UserId agentId
	) {
		Appointment appointment = new Appointment(
				appointmentId,
				appointmentDate,
				new AppointmentState("PENDING"),
				propertyId,
				userId,
				agentId
		);

		appointment.record(
				new AppointmentCreatedDomainEvent(
						appointmentId.value(),
						appointmentDate.value(),
						"PENDING",
						propertyId.value(),
						userId.value(),
						agentId.value()
				)
		);

		return appointment;
	}

	public void updateState(AppointmentState appointmentState) {
		this.appointmentState = appointmentState;

		this.record(
				new AppointmentUpdatedDomainEvent(
						appointmentId.value(),
						appointmentDate.value(),
						appointmentState.value(),
						propertyId.value(),
						userId.value(),
						agentId.value()
				)
		);
	}

	public HashMap<String, Object> data() {
		return new HashMap<>() {{
			put("id", appointmentId.value());
			put("date", appointmentDate.value());
			put("state", appointmentState.value());
			put("propertyId", propertyId.value());
			put("userId", userId.value());
			put("agentId", agentId.value());
		}};
	}
}
