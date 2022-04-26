package com.webdev.realstate.properties.property.application.find;

import com.webdev.realstate.properties.property.domain.Property;

import java.util.HashMap;

public class PropertyFindByIdResponse {

	private Property property;

	public PropertyFindByIdResponse(Property property) {
		this.property = property;
	}

	public HashMap<String, Object> response() {
		if (property == null) {
			return new HashMap<>();
		}

		return property.data();
	}
}
