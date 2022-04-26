package com.webdev.realstate.properties.property.application.find_all;

import com.webdev.realstate.properties.property.domain.Property;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class PropertyFindAllResponse {
	private List<Property> properties;

	public PropertyFindAllResponse(List<Property> properties) {
		this.properties = properties;
	}

	public List<HashMap<String, Object>> response() {
		return properties.stream().map(
				properties -> properties.data()
		).collect(Collectors.toList());
	}
}
