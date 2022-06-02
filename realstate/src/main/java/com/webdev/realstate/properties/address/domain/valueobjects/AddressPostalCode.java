package com.webdev.realstate.properties.address.domain.valueobjects;

import com.webdev.realstate.shared.domain.aggregate.StringValueObject;

public class AddressPostalCode extends StringValueObject {

    private AddressPostalCode() {}

    public AddressPostalCode(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {

    }

}
