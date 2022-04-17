package com.webdev.realstate.appointments.request.domain.valueobjects;

import com.webdev.realstate.shared.domain.aggregate.StringValueObject;

public class RequestState extends StringValueObject {

	public RequestState(String value) {
		this.value = value;
	}

	// Check if it is!!
	// PENDING
	// APPROVED
	// REJECTED
}
