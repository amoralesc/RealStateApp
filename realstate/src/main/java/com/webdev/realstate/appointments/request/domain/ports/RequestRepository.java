package com.webdev.realstate.appointments.request.domain.ports;

import com.webdev.realstate.appointments.request.domain.Request;
import com.webdev.realstate.appointments.request.domain.valueobjects.RequestId;
import com.webdev.realstate.users.user.domain.valueobjects.UserId;
import com.webdev.realstate.users.user.domain.valueobjects.UserIsAgent;

import java.util.List;
import java.util.Optional;

public interface RequestRepository {

	void save(Request request);

	void update(Request request);

	void delete(Request request);

	Optional<Request> findById(RequestId requestId);

	Optional<List<Request>> findByUser(UserId userId, UserIsAgent isAgent);

	Optional<List<Request>> findAll();
}
