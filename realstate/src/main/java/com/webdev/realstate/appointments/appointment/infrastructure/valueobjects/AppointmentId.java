package com.webdev.realstate.appointments.appointment.infrastructure.valueobjects;

import com.webdev.realstate.shared.domain.aggregate.CustomUUID;

public class AppointmentId extends CustomUUID {
    public AppointmentId(String value) {
        super(value);
    }
}
