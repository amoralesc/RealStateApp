package com.webdev.realstate.appointments.request.application.find;

import com.webdev.realstate.appointments.request.domain.Request;
import com.webdev.realstate.appointments.request.domain.ports.RequestRepository;
import com.webdev.realstate.appointments.request.domain.valueobjects.RequestState;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RequestFindByState {
    private RequestRepository repository;

    public RequestFindByState(RequestRepository repository) {
        this.repository = repository;
    }

    public List<Request> execute(String requestState) {
        List<Request> requests = new ArrayList<>();
        Optional<List<Request>> optionalRequests = repository.findByState(new RequestState(requestState));
        if (optionalRequests.isPresent()) {
            requests = optionalRequests.get();
        }
        return requests;
    }
}
