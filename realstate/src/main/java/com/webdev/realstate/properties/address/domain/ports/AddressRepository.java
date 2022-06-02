package com.webdev.realstate.properties.address.domain.ports;

import com.webdev.realstate.properties.address.domain.Address;
import com.webdev.realstate.properties.address.domain.valueobjects.AddressId;

import java.util.List;
import java.util.Optional;

public interface AddressRepository {
    void save(Address address);
    void update(Address address);
    Optional<Address> find(AddressId addressId);
    Optional<List<Address>> all();
    void delete(Address address);
}
