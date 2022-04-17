package com.webdev.realstate.appointments.request.application.find;

import com.webdev.realstate.appointments.request.domain.Request;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class RequestFindByStateResponse {

    private List<Request> requests;

    public RequestFindByStateResponse(List<Request> requests) {
        this.requests = requests;
    }

    public List<HashMap<String, Object>> response() {
        List<HashMap<String, Object>> response = requests.stream().map(request-> request.data()).collect(Collectors.toList());
        return response;
    }
}
