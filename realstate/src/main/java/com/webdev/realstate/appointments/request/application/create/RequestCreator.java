package com.webdev.realstate.appointments.request.application.create;

import com.webdev.realstate.appointments.request.domain.Request;
import com.webdev.realstate.appointments.request.domain.ports.RequestRepository;
import com.webdev.realstate.appointments.request.domain.valueobjects.RequestDate;
import com.webdev.realstate.appointments.request.domain.valueobjects.RequestId;
import com.webdev.realstate.users.user.domain.valueobjects.UserId;

import java.util.Date;

public class RequestCreator {
    private RequestRepository repository;

    public RequestCreator(RequestRepository repository) {
        this.repository = repository;
    }

    public void execute(String requestId, Date requestDate, String userId, String agentId) {
        Request request = Request.create(
                new RequestId(requestId),
                new RequestDate(requestDate),
                new UserId(userId),
                new UserId(agentId)
        );
        repository.save(request);
    }
}
