package com.webdev.realstate.properties.property.domain.exceptions;

public class InvalidPrice extends RuntimeException {
    public InvalidPrice(String message) {
        super(message);
    }
}
