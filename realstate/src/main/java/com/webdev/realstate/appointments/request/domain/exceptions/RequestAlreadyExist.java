package com.webdev.realstate.appointments.request.domain.exceptions;

public class RequestAlreadyExist extends RuntimeException {
    public RequestAlreadyExist(String message) {
        super(message);
    }
}