package com.webdev.realstate.appointments.request.domain.valueobjects;

import com.webdev.realstate.shared.domain.aggregate.DateValueObject;

import java.util.Date;

public class RequestDate extends DateValueObject {
	public RequestDate(Date value) {
		this.value = value;
	}
}
