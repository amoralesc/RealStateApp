package com.webdev.realstate.properties.property.application.find_all;

import com.webdev.realstate.properties.property.domain.Property;
import com.webdev.realstate.properties.property.domain.ports.PropertyRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PropertyFindAll {
	private final PropertyRepository repository;

	public PropertyFindAll(PropertyRepository repository) {
		this.repository = repository;
	}

	public List<Property> execute() {
		List<Property> properties = new ArrayList<>();
		Optional<List<Property>> optionalProperties = repository.findAll();
		if (optionalProperties.isPresent()) {
			properties = optionalProperties.get();
		}
		return properties;

	}
}
