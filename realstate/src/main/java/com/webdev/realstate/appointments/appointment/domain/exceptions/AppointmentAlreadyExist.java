package com.webdev.realstate.appointments.appointment.domain.exceptions;

public class AppointmentAlreadyExist extends RuntimeException {
    public AppointmentAlreadyExist(String message) {
        super(message);
    }
}
