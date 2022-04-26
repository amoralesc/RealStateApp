package com.webdev.realstate.appointments.request.application.find_all;

import com.webdev.realstate.appointments.request.domain.Request;
import com.webdev.realstate.appointments.request.domain.ports.RequestRepository;

import java.util.ArrayList;
import java.util.List;

public class RequestFindAll {

	private final RequestRepository repository;

	public RequestFindAll(RequestRepository repository) {
		this.repository = repository;
	}

	public List<Request> execute() {
		List<Request> requests = new ArrayList<>();
		repository.findAll().ifPresent(
				requests::addAll
		);
		return requests;
	}
}
