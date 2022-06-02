package com.webdev.realstate.properties.address.application.find;

import com.webdev.realstate.properties.address.domain.Address;
import com.webdev.realstate.properties.address.domain.ports.AddressRepository;
import com.webdev.realstate.properties.address.domain.valueobjects.AddressId;

public class AddressByIdFinder {

    private AddressRepository repository;

    public AddressByIdFinder(AddressRepository repository) { this.repository = repository; }

    public Address execute(String id) {
        return repository.find(new AddressId(id)).get();
    }

}
