package com.webdev.realstate.properties.property.application.update;

import com.webdev.realstate.properties.property.domain.ports.PropertyRepository;

public class PropertyUpdate {

	private PropertyRepository repository;

	public PropertyUpdate(PropertyRepository repository) {
		this.repository = repository;
	}

	public void execute() {
	}
}
