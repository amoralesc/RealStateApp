package com.webdev.realstate.properties.address.domain.events;

import com.webdev.realstate.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class AddressCreatedDomainEvent extends DomainEvent {

    private String city;
    private String postalCode;
    private String detail;
    private String info;
    private String userId;

    public AddressCreatedDomainEvent() {
        super(null);
    }

    public AddressCreatedDomainEvent(String aggregateId, String city, String postalCode, String detail, String info, String userId) {
        super(aggregateId);
        this.city = city;
        this.postalCode = postalCode;
        this.detail = detail;
        this.info = info;
        this.userId = userId;
    }

    public AddressCreatedDomainEvent(String aggregateId, String eventId, String occurredOn, String city, String detail, String info, String userId) {
        super(aggregateId, eventId, occurredOn);
        this.city = city;
        this.postalCode = postalCode;
        this.detail = detail;
        this.info = info;
        this.userId = userId;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getDetail() {
        return detail;
    }

    public String getInfo() {
        return info;
    }

    public String getUserId() { return userId; }

    @Override
    public String eventName() {
        return "add.address";
    }

    @Override
    public HashMap<String, Serializable> toPrimitive() {
        return new HashMap<String, Serializable>() {{
            put("city", city);
            put("postalCode", postalCode);
            put("detail", detail);
            put("info", info);
            put("userId", userId);
        }};
    }

    @Override
    public DomainEvent fromPrimitive(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new AddressCreatedDomainEvent(aggregateId, eventId, occurredOn, (String) body.get("city"), (String) body.get("detail"), (String) body.get("info"),
                (String) body.get("userId"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressCreatedDomainEvent that = (AddressCreatedDomainEvent) o;
        return Objects.equals(city, that.city) && Objects.equals(detail, that.detail) && Objects.equals(info, that.info) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, detail, info, userId);
    }
}
