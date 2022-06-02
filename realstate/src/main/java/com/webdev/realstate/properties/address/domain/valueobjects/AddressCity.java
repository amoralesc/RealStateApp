package com.webdev.realstate.properties.address.domain.valueobjects;

import com.webdev.realstate.shared.domain.aggregate.StringValueObject;

public class AddressCity extends StringValueObject {

    private AddressCity() {}

    public AddressCity(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {

    }
}
