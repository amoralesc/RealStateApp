package com.webdev.realstate.appointments.request.domain.valueobjects;

import com.webdev.realstate.shared.domain.aggregate.BooleanValueObject;

public class RequestState extends BooleanValueObject {
	public RequestState(Boolean value) {
		this.value = value;
	}
}
