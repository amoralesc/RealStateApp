package com.webdev.realstate.appointments.request.application.find;

import com.webdev.realstate.appointments.request.domain.Request;
import com.webdev.realstate.appointments.request.domain.ports.RequestRepository;
import com.webdev.realstate.users.user.domain.valueobjects.UserId;
import com.webdev.realstate.users.user.domain.valueobjects.UserIsAgent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RequestFindByUserId {
	private RequestRepository repository;

	public RequestFindByUserId(RequestRepository repository) {
		this.repository = repository;
	}

	public List<Request> execute(String userId, Boolean isAgent) {
		List<Request> requests = new ArrayList<>();
		Optional<List<Request>> optionalRequests = repository.findByUserId(new UserId(userId), new UserIsAgent(isAgent));
		if (optionalRequests.isPresent()) {
			requests = optionalRequests.get();
		}
		return requests;
	}
}
