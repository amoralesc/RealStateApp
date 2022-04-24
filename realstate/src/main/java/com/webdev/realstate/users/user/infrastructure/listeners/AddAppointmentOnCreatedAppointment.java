package com.webdev.realstate.users.user.infrastructure.listeners;

import com.webdev.realstate.appointments.appointment.domain.domain_events.AppointmentCreatedDomainEvent;
import com.webdev.realstate.users.user.application.add.UserAddAppointment;

public class AddAppointmentOnCreatedAppointment {

	private UserAddAppointment adder;

	public AddAppointmentOnCreatedAppointment(UserAddAppointment adder) {
		this.adder = adder;
	}

	public void onCreatedAppointment(AppointmentCreatedDomainEvent event) {
		adder.execute(
				event.aggregateId(),
				event.getDate(),
				event.getState(),
				event.getPropertyId(),
				event.getUserId(),
				event.getAgentId()
		);
	}
}
