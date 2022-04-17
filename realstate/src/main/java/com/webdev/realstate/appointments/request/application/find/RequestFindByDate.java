package com.webdev.realstate.appointments.request.application.find;

import com.webdev.realstate.appointments.request.domain.Request;
import com.webdev.realstate.appointments.request.domain.ports.RequestRepository;
import com.webdev.realstate.appointments.request.domain.valueobjects.RequestDate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class RequestFindByDate {
    private RequestRepository repository;

    public RequestFindByDate(RequestRepository repository) {
        this.repository = repository;
    }

    public List<Request> execute(Date requestDate) {
        List<Request> requests = new ArrayList<>();
        Optional<List<Request>> optionalRequests = repository.findByDate(new RequestDate(requestDate));
        if (optionalRequests.isPresent()) {
            requests = optionalRequests.get();
        }
        return requests;
    }
}
