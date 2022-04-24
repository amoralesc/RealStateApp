package com.webdev.realstate.users.user.infrastructure.listeners;

import com.webdev.realstate.appointments.request.domain.events.RequestCreatedDomainEvent;
import com.webdev.realstate.users.user.application.add.UserAddRequest;

public class AddRequestOnCreatedRequest {

	private UserAddRequest adder;

	public AddRequestOnCreatedRequest(UserAddRequest adder) {
		this.adder = adder;
	}

	public void onCreatedRequest(RequestCreatedDomainEvent event) {
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
