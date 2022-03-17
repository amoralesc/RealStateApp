package com.webdev.realstate.appointments.request.domain;

import com.webdev.realstate.appointments.request.domain.valueobjects.*;

import java.util.HashMap;

public class Request {
	RequestId requestId;
	RequestDate requestDate;
	RequestState requestState;

	public Request(RequestId requestId, RequestDate requestDate, RequestState requestState) {
		this.requestId = requestId;
		this.requestDate = requestDate;
		this.requestState = requestState;
	}

	public static Request create(RequestId requestId, RequestDate requestDate) {
		Request request = new Request(requestId, requestDate, new RequestState(true));
		return request;
	}

	public HashMap<String, Object> data() {
		HashMap<String, Object> data = new HashMap<>() {{
			put("id", requestId.value());
			put("date", requestDate.value());
			put("state", requestState.value());
		}};
		return data;
	}
}
