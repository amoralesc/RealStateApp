package com.webdev.realstate.users.user.infrastructure.listeners;

import com.webdev.realstate.appointments.appointment.domain.events.AppointmentCreatedDomainEvent;
import com.webdev.realstate.users.user.application.add.UserAddAppointment;

public class AddAppointmentOnAppointmentCreated {

	private UserAddAppointment adder;

	public AddAppointmentOnAppointmentCreated(UserAddAppointment adder) {
		this.adder = adder;
	}

	public void on(AppointmentCreatedDomainEvent event) {
		System.out.println("El evento llego" + event.getAgentId());
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
