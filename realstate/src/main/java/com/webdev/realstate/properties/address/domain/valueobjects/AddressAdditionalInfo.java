package com.webdev.realstate.properties.address.domain.valueobjects;

import com.webdev.realstate.shared.domain.aggregate.StringValueObject;

public class AddressAdditionalInfo extends StringValueObject {

    private AddressAdditionalInfo() {}

    public AddressAdditionalInfo(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {

    }
}
