package com.webdev.realstate.appointments.request.application.update;

import com.webdev.realstate.appointments.request.domain.Request;
import com.webdev.realstate.appointments.request.domain.ports.RequestRepository;
import com.webdev.realstate.appointments.request.domain.valueobjects.RequestId;
import com.webdev.realstate.appointments.request.domain.valueobjects.RequestState;
import com.webdev.realstate.shared.domain.bus.event.EventBus;

import java.util.Optional;

public class RequestUpdate {

	private final RequestRepository repository;
	private final EventBus eventBus;

	public RequestUpdate(RequestRepository repository, EventBus eventBus) {
		this.repository = repository;
		this.eventBus = eventBus;
	}

	public void execute(String requestId, String requestState) {
		Optional<Request> optionalRequest =
				repository.findById(new RequestId(requestId));

		if (optionalRequest.isPresent()) {
			Request request = optionalRequest.get();
			request.updateState(
					new RequestState(requestState)
			);

			repository.update(request);
			eventBus.publish(request.pullDomainEvents());
		}
	}
}
