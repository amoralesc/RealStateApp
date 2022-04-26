package com.webdev.realstate.properties.property.application.find;

import com.webdev.realstate.properties.property.domain.Property;
import com.webdev.realstate.properties.property.domain.ports.PropertyRepository;
import com.webdev.realstate.properties.property.domain.valueobjects.PropertyId;

import java.util.Optional;

public class PropertyFindById {

	private final PropertyRepository repository;

	public PropertyFindById(PropertyRepository repository) {
		this.repository = repository;
	}

	public Property execute(String propertyId) {
		Property property = null;
		Optional<Property> optionalProperty = repository.findById(new PropertyId(propertyId));
		if (optionalProperty.isPresent()) {
			property = optionalProperty.get();
		}
		return property;
	}
}
