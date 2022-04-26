package com.webdev.realstate.properties.property.application.find;

import com.webdev.realstate.properties.property.domain.Property;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class PropertyFindByFilterResponse {
	private List<Property> properties;

	public PropertyFindByFilterResponse(List<Property> properties) {
		this.properties = properties;
	}

	public List<HashMap<String, Object>> response() {
		return properties.stream().map(
				properties -> properties.data()
		).collect(Collectors.toList());
	}
}
