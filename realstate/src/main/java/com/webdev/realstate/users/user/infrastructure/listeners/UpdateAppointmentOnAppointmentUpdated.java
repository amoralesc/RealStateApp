package com.webdev.realstate.users.user.infrastructure.listeners;

import com.webdev.realstate.appointments.appointment.domain.events.AppointmentUpdatedDomainEvent;
import com.webdev.realstate.users.user.application.update.UserUpdateAppointment;

public class UpdateAppointmentOnAppointmentUpdated {

	private UserUpdateAppointment updater;

	public UpdateAppointmentOnAppointmentUpdated(UserUpdateAppointment updater) {
		this.updater = updater;
	}

	public void on(AppointmentUpdatedDomainEvent event) {
		updater.execute(
				event.aggregateId(),
				event.getDate(),
				event.getState(),
				event.getPropertyId(),
				event.getUserId(),
				event.getAgentId()
		);
	}
}
