package com.webdev.realstate.properties.address.domain.valueobjects;

import com.webdev.realstate.shared.domain.aggregate.StringValueObject;

public class AddressDetail extends StringValueObject {

    private AddressDetail() {}

    public AddressDetail(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {

    }
}
