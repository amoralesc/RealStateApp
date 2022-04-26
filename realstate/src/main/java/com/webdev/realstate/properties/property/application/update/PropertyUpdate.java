package com.webdev.realstate.properties.property.application.update;

import com.webdev.realstate.properties.property.domain.Property;
import com.webdev.realstate.properties.property.domain.entities.PropertyAddress;
import com.webdev.realstate.properties.property.domain.ports.PropertyRepository;
import com.webdev.realstate.properties.property.domain.valueobjects.PropertyId;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PropertyUpdate {

	private final PropertyRepository repository;

	public PropertyUpdate(PropertyRepository repository) {
		this.repository = repository;
	}

	public void execute(String propertyId) {
		Optional<Property> optionalProperty = repository.findById(new PropertyId(propertyId));

		if (optionalProperty.isPresent()) {
			Property property = optionalProperty.get();
			repository.update(property);
		}
	}
}
