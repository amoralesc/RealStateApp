package com.webdev.realstate.properties.property.domain.ports;

import com.webdev.realstate.properties.property.domain.Property;
import com.webdev.realstate.properties.property.domain.valueobjects.*;

import java.util.List;
import java.util.Optional;

public interface PropertyRepository {

	void save(Property property);

	void update(Property property);

	Optional<Property> findById(PropertyId propertyId);

	Optional<List<Property>> findByType(PropertyType propertyType);

	Optional<List<Property>> findByRooms(PropertyQuantityRooms propertyQuantityRooms);

	Optional<List<Property>> findByBaths(PropertyQuantityBathrooms propertyQuantityBathrooms);

	Optional<List<Property>> findByArea(PropertyArea propertyArea);

	Optional<List<Property>> findByPrice(PropertyPrice propertyPrice);

	Optional<List<Property>> findAll();
}
