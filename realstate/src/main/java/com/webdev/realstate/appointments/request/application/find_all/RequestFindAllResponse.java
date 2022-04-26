package com.webdev.realstate.appointments.request.application.find_all;

import com.webdev.realstate.appointments.request.domain.Request;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class RequestFindAllResponse {

	private List<Request> requests;

	public RequestFindAllResponse(List<Request> requests) {
		this.requests = requests;
	}

	public List<HashMap<String, Object>> response() {
		return requests.stream().map(
				request -> request.data()
		).collect(Collectors.toList());
	}
}
