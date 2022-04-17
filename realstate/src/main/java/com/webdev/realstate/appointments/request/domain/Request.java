package com.webdev.realstate.appointments.request.domain;

import com.webdev.realstate.appointments.request.domain.valueobjects.*;
import com.webdev.realstate.users.user.domain.User;
import com.webdev.realstate.users.user.domain.valueobjects.UserId;

import java.util.HashMap;

public class Request {
	RequestId requestId;
	RequestDate requestDate;
	RequestState requestState;
	UserId userId;
	UserId agentId;

	public Request(
			RequestId requestId, RequestDate requestDate, RequestState requestState,
			UserId userId, UserId agentId
	) {
		this.requestId = requestId;
		this.requestDate = requestDate;
		this.requestState = requestState;
		this.userId = userId;
		this.agentId = agentId;
	}

	public static Request create(
			RequestId requestId, RequestDate requestDate, UserId userId, UserId agentId
	) {
		return new Request(
				requestId,
				requestDate,
				new RequestState("PENDING"),
				userId,
				agentId
		);
	}

	public HashMap<String, Object> data() {
		return new HashMap<>() {{
			put("id", requestId.value());
			put("date", requestDate.value());
			put("state", requestState.value());
			put("userId", userId.value());
			put("agentId", agentId.value());
		}};
	}
}
