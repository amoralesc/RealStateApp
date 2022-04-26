package com.webdev.realstate.properties.property.application.find;

import com.webdev.realstate.properties.property.domain.Property;
import com.webdev.realstate.properties.property.domain.ports.PropertyRepository;
import com.webdev.realstate.properties.property.domain.valueobjects.PropertyQuantityRooms;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PropertyFindByRooms {

	private PropertyRepository repository;

	public PropertyFindByRooms(PropertyRepository repository) {
		this.repository = repository;
	}

	public List<Property> execute(Integer propertyQuantityRooms) {
		List<Property> properties = new ArrayList<>();
		Optional<List<Property>> optionalProperties = repository.findByRooms(new PropertyQuantityRooms(propertyQuantityRooms));
		if (optionalProperties.isPresent()) {
			properties = optionalProperties.get();
		}
		return properties;
	}
}
