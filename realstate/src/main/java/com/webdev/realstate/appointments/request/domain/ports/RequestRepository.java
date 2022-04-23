package com.webdev.realstate.appointments.request.domain.ports;

import com.webdev.realstate.appointments.request.domain.Request;
import com.webdev.realstate.appointments.request.domain.valueobjects.RequestDate;
import com.webdev.realstate.appointments.request.domain.valueobjects.RequestState;
import com.webdev.realstate.users.user.domain.valueobjects.UserId;
import com.webdev.realstate.users.user.domain.valueobjects.UserIsAgent;

import java.util.List;
import java.util.Optional;

public interface RequestRepository {

	void save(Request request);

	void update(Request request);

	Optional<List<Request>> findByUserId(UserId userId, UserIsAgent isAgent);

	Optional<List<Request>> findByDate(RequestDate requestDate);

	Optional<List<Request>> findByState(RequestState requestState);
}
