package com.webdev.realstate.appointments.request.domain;

import com.webdev.realstate.appointments.request.domain.events.RequestCreatedDomainEvent;
import com.webdev.realstate.appointments.request.domain.events.RequestUpdatedDomainEvent;
import com.webdev.realstate.appointments.request.domain.valueobjects.RequestDate;
import com.webdev.realstate.appointments.request.domain.valueobjects.RequestId;
import com.webdev.realstate.appointments.request.domain.valueobjects.RequestState;
import com.webdev.realstate.properties.property.domain.valueobjects.PropertyId;
import com.webdev.realstate.shared.domain.aggregate.AggregateRoot;
import com.webdev.realstate.users.user.domain.valueobjects.UserId;

import java.util.HashMap;

public class Request extends AggregateRoot {
	RequestId requestId;
	RequestDate requestDate;
	RequestState requestState;
	PropertyId propertyId;
	UserId userId;
	UserId agentId;

	public Request() {
	}

	public Request(
			RequestId requestId, RequestDate requestDate, RequestState requestState, PropertyId propertyId,
			UserId userId, UserId agentId
	) {
		this.requestId = requestId;
		this.requestDate = requestDate;
		this.requestState = requestState;
		this.propertyId = propertyId;
		this.userId = userId;
		this.agentId = agentId;
	}

	public static Request create(
			RequestId requestId, RequestDate requestDate, PropertyId propertyId, UserId userId, UserId agentId
	) {
		Request request = new Request(
				requestId,
				requestDate,
				new RequestState("PENDING"),
				propertyId,
				userId,
				agentId
		);

		request.record(
				new RequestCreatedDomainEvent(
						requestId.value(),
						requestDate.value(),
						"PENDING",
						propertyId.value(),
						userId.value(),
						agentId.value()
				)
		);

		return request;
	}

	public void updateState(RequestState requestState) {
		this.requestState = requestState;

		this.record(
				new RequestUpdatedDomainEvent(
						requestId.value(),
						requestDate.value(),
						requestState.value(),
						propertyId.value(),
						userId.value(),
						agentId.value()
				)
		);
	}

	public HashMap<String, Object> data() {
		return new HashMap<>() {{
			put("id", requestId.value());
			put("date", requestDate.value());
			put("state", requestState.value());
			put("propertyId", propertyId.value());
			put("userId", userId.value());
			put("agentId", agentId.value());
		}};
	}
}
