package com.webdev.realstate.appointments.request.application.delete;

import com.webdev.realstate.appointments.request.domain.Request;
import com.webdev.realstate.appointments.request.domain.ports.RequestRepository;
import com.webdev.realstate.appointments.request.domain.valueobjects.RequestId;

import java.util.Optional;

public class RequestDelete {

	private RequestRepository repository;

	public RequestDelete(RequestRepository repository) {
		this.repository = repository;
	}

	public void execute(String id) {
		Optional<Request> optionalRequest =
				repository.findById(new RequestId(id));
		optionalRequest.ifPresent(
				request -> repository.delete(request)
		);
	}
}
