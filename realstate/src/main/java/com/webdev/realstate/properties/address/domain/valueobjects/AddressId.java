package com.webdev.realstate.properties.address.domain.valueobjects;

import com.webdev.realstate.shared.domain.aggregate.CustomUUID;

public class AddressId extends CustomUUID {

    private AddressId() {}

    public AddressId(String value) {
        super(value);
    }

}
