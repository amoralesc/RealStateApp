package com.webdev.realstate.properties.property.application.find;

import com.webdev.realstate.properties.property.domain.Property;
import com.webdev.realstate.properties.property.domain.ports.PropertyRepository;
import com.webdev.realstate.properties.property.domain.valueobjects.PropertyQuantityBathrooms;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PropertyFindByBaths {

	private PropertyRepository repository;

	public PropertyFindByBaths(PropertyRepository repository) {
		this.repository = repository;
	}

	public List<Property> execute(Integer propertyQuantityBathrooms) {
		List<Property> properties = new ArrayList<>();
		Optional<List<Property>> optionalProperties = repository.findByBaths(new PropertyQuantityBathrooms(propertyQuantityBathrooms));
		if (optionalProperties.isPresent()) {
			properties = optionalProperties.get();
		}
		return properties;
	}
}
