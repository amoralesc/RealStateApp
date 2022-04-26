package com.webdev.realstate.appointments.request.application.update;

import com.webdev.realstate.appointments.request.domain.Request;
import com.webdev.realstate.appointments.request.domain.ports.RequestRepository;
import com.webdev.realstate.appointments.request.domain.valueobjects.RequestId;
import com.webdev.realstate.appointments.request.domain.valueobjects.RequestState;

import java.util.Optional;

public class RequestUpdate {

	private final RequestRepository repository;

	public RequestUpdate(RequestRepository repository) {
		this.repository = repository;
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
		}
	}
}
