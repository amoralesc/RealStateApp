package com.webdev.realstate.properties.address.application.create;

import com.webdev.realstate.properties.address.domain.Address;
import com.webdev.realstate.properties.address.domain.ports.AddressRepository;
import com.webdev.realstate.properties.address.domain.valueobjects.*;
import com.webdev.realstate.shared.domain.bus.event.EventBus;

public class AddressCreator {

    private final AddressRepository repository;
    private final EventBus eventBus;

    public AddressCreator(AddressRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

    public void execute(String id, String city, String detail, String additionalInfo, String neighborhood, String userId) {
        Address address = Address.create(new AddressId(id), new AddressCity(city), new AddressDetail(detail),
                new AddressAdditionalInfo(additionalInfo), new AddressNeighborhood(neighborhood), new UserId(userId));
        this.repository.save(address);
        this.eventBus.publish(address.pullDomainEvents());
    }

}
