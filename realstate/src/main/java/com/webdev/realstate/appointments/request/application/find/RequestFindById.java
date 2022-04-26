package com.webdev.realstate.appointments.request.application.find;

import com.webdev.realstate.appointments.request.domain.Request;
import com.webdev.realstate.appointments.request.domain.ports.RequestRepository;
import com.webdev.realstate.appointments.request.domain.valueobjects.RequestId;

import java.util.Optional;

public class RequestFindById {

	private final RequestRepository repository;

	public RequestFindById(RequestRepository repository) {
		this.repository = repository;
	}

	public Request execute(String id) {
		Request request = null;
		Optional<Request> optionalRequest = repository.findById(new RequestId(id));
		if (optionalRequest.isPresent()) {
			request = optionalRequest.get();
		}
		return request;
	}
}
