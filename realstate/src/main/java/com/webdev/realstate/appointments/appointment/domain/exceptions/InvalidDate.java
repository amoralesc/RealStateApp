package com.webdev.realstate.appointments.appointment.domain.exceptions;

public class InvalidDate extends RuntimeException {
    public InvalidDate(String message) {
        super(message);
    }
}
