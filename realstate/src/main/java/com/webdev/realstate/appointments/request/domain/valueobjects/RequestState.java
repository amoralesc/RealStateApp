package com.webdev.realstate.appointments.request.domain.valueobjects;

import com.webdev.realstate.appointments.request.domain.exceptions.InvalidRequestState;
import com.webdev.realstate.shared.domain.aggregate.StringValueObject;

public class RequestState extends StringValueObject {

	public RequestState(String value) {
		this.value = value;
	}

	// Check if it is!!
	// PENDING
	// APPROVED
	// REJECTED

	private void validate(String value) {
		stateValue(value);
	}

	public void stateValue(String value) {
		if (!value.equals("PENDING") && !value.equals("APPROVED") && !value.equals("REJECTED")) {
			throw new InvalidRequestState("Request state must be: PENDING, APPROVED or REJECTED");
		}
	}
}
