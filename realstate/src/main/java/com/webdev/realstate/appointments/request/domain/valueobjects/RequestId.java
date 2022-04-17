package com.webdev.realstate.appointments.request.domain.valueobjects;

import com.webdev.realstate.shared.domain.aggregate.CustomUUID;

public class RequestId extends CustomUUID {
    public RequestId(String value) {
        super(value);
    }
}
