package com.webdev.realstate.properties.address.domain.valueobjects;

import com.webdev.realstate.shared.domain.aggregate.StringValueObject;

public class AddressNeighborhood extends StringValueObject {

    private AddressNeighborhood() {}

    public AddressNeighborhood(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {

    }

}
