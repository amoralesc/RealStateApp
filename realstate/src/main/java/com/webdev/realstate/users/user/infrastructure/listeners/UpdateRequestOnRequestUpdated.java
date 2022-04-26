package com.webdev.realstate.users.user.infrastructure.listeners;

import com.webdev.realstate.appointments.request.domain.events.RequestUpdatedDomainEvent;
import com.webdev.realstate.users.user.application.update.UserUpdateRequest;

public class UpdateRequestOnRequestUpdated {

	private UserUpdateRequest updater;

	public UpdateRequestOnRequestUpdated(UserUpdateRequest updater) {
		this.updater = updater;
	}

	public void on(RequestUpdatedDomainEvent event) {
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
