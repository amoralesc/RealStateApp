package com.webdev.realstate.properties.address.application.all;

import com.webdev.realstate.properties.address.domain.Address;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class AddressFindAllResponse {

    private List<Address> addresses;

    public AddressFindAllResponse(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<HashMap<String, Object>> response() {
        return addresses.stream().map(address -> address.data()).collect(Collectors.toList());
    }

}
