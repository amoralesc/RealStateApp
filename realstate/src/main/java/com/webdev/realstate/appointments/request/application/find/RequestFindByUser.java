package com.webdev.realstate.appointments.request.application.find;

import com.webdev.realstate.appointments.request.domain.Request;
import com.webdev.realstate.appointments.request.domain.ports.RequestRepository;
import com.webdev.realstate.appointments.request.domain.valueobjects.RequestState;
import com.webdev.realstate.users.user.domain.valueobjects.UserId;
import com.webdev.realstate.users.user.domain.valueobjects.UserIsAgent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RequestFindByUser {

	private RequestRepository repository;

	public RequestFindByUser(RequestRepository repository) {
		this.repository = repository;
	}

	public List<Request> execute(String userId, Boolean isAgent, Optional<String> state) {
		List<Request> requests = new ArrayList<>();
		Optional<List<Request>> optionalRequests =
				repository.findByUser(
						new UserId(userId),
						new UserIsAgent(isAgent)
				);

		if (optionalRequests.isPresent()) {
			requests = optionalRequests.get();
		}
		if (state.isPresent()) {
			RequestState requestState = new RequestState(state.get());

			requests = requests.stream().filter(request ->
					request.data().get("state").equals(requestState.value())
			).collect(Collectors.toList());
		}
		return requests;
	}
}
