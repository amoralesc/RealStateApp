package com.webdev.realstate.shared.infrastructure.rabbitMQ;

import com.webdev.realstate.shared.domain.bus.event.DomainEvent;

import java.util.HashMap;

public class DomainEventsInformation {

    private final HashMap<String, Class<? extends DomainEvent>> indexedDomainEvent = new HashMap<>();
    private final HashMap<String, String> domainEventSubscribers = new HashMap<>();

    public DomainEventsInformation() {
       /* indexedDomainEvent.put("add.address", AddressCreatedDomainEvent.class);
        domainEventSubscribers.put("productSystem.users.address.add.address", "AddAddressOnCreatedAddress");*/
    }

    public Class<? extends DomainEvent> getDomainEvent(String name) {
        return indexedDomainEvent.get(name);
    }

    public boolean validateEventSubscriber(String name) {
        return domainEventSubscribers.containsKey(name);
    }

    public String getEventSubscriber(String name) {
        return domainEventSubscribers.get(name);
    }

}