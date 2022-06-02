package com.webdev.realstate.properties.address.domain;

import com.webdev.realstate.properties.address.domain.events.AddressCreatedDomainEvent;
import com.webdev.realstate.properties.address.domain.valueobjects.*;
import com.webdev.realstate.shared.domain.aggregate.AggregateRoot;

import java.util.HashMap;

public class Address extends AggregateRoot {

    private AddressId id;
    private AddressCity city;
    private AddressDetail detail;
    private AddressAdditionalInfo additionalInfo;
    private AddressNeighborhood neighborhood;
    private UserId userId;

    private Address() {}

    public Address(AddressId id, AddressCity city, AddressDetail detail, AddressAdditionalInfo additionalInfo, AddressNeighborhood neighborhood, UserId userId) {
        this.id = id;
        this.city = city;
        this.detail = detail;
        this.additionalInfo = additionalInfo;
        this.neighborhood = neighborhood;
        this.userId = userId;
    }

    public static Address create(AddressId id, AddressCity city, AddressDetail detail, AddressAdditionalInfo additionalInfo, AddressNeighborhood neighborhood, UserId userId) {
        Address address = new Address(id, city, detail, additionalInfo, neighborhood, userId);
        System.out.println("ENTREE A ADDRESS");
        address.record(new AddressCreatedDomainEvent(id.value(), city.value(), detail.value(), additionalInfo.value(), userId.value()));
        System.out.println("SALI");
        return address;
    }

    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<>() {{
            put("id", id.value());
            put("city", city.value());
            put("detail", detail.value());
            put("additionalInfo", additionalInfo.value());
            put("neighborhood", neighborhood.value());
            put("userId", userId.value());
        }};
        return data;
    }

}
