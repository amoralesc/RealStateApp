package com.webdev.realstate.appointments.request.application.create;

import com.webdev.realstate.appointments.request.domain.Request;
import com.webdev.realstate.appointments.request.domain.ports.RequestRepository;
import com.webdev.realstate.appointments.request.domain.valueobjects.RequestDate;
import com.webdev.realstate.appointments.request.domain.valueobjects.RequestId;
import com.webdev.realstate.properties.property.domain.valueobjects.PropertyId;
import com.webdev.realstate.shared.domain.bus.event.EventBus;
import com.webdev.realstate.users.user.domain.valueobjects.UserId;

import java.util.Date;

public class RequestCreator {

	private final RequestRepository repository;
	private final EventBus eventBus;

	public RequestCreator(RequestRepository repository, EventBus eventBus) {
		this.repository = repository;
		this.eventBus = eventBus;
	}

	public void execute(String requestId, Date requestDate, String propertyId, String userId, String agentId) {
		Request request = Request.create(
				new RequestId(requestId),
				new RequestDate(requestDate),
				new PropertyId(propertyId),
				new UserId(userId),
				new UserId(agentId)
		);
		repository.save(request);
		eventBus.publish(request.pullDomainEvents());
	}
}
