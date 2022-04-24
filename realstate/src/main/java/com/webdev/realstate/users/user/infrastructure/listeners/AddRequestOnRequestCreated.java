package com.webdev.realstate.users.user.infrastructure.listeners;

import com.webdev.realstate.appointments.request.domain.events.RequestCreatedDomainEvent;
import com.webdev.realstate.users.user.application.add.UserAddRequest;

public class AddRequestOnRequestCreated {

	private UserAddRequest adder;

	public AddRequestOnRequestCreated(UserAddRequest adder) {
		this.adder = adder;
	}

	public void on(RequestCreatedDomainEvent event) {
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
