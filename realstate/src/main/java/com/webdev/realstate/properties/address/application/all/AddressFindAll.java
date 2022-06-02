package com.webdev.realstate.properties.address.application.all;

import com.webdev.realstate.properties.address.domain.Address;
import com.webdev.realstate.properties.address.domain.ports.AddressRepository;

import java.util.ArrayList;
import java.util.List;

public class AddressFindAll {

    private AddressRepository repository;

    public AddressFindAll(AddressRepository repository) {
        this.repository = repository;
    }

    public List<Address> execute() {
        List<Address> result = new ArrayList<Address>();
        if (repository.all().isPresent())
            result = repository.all().get();
        return result;
    }
}
