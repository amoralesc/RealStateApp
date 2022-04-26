package com.webdev.realstate.appointments.request.application.find;


import com.webdev.realstate.appointments.request.domain.Request;

import java.util.HashMap;

public class RequestFindByIdResponse {

	private Request request;

	public RequestFindByIdResponse(Request request) {
		this.request = request;
	}

	public HashMap<String, Object> response() {
		if (request == null) {
			return new HashMap<>();
		}

		return request.data();
	}
}
