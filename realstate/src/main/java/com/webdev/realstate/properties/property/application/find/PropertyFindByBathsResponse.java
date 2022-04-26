package com.webdev.realstate.properties.property.application.find;

import com.webdev.realstate.properties.property.domain.Property;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class PropertyFindByBathsResponse {

	private List<Property> properties;

	public PropertyFindByBathsResponse(List<Property> properties) {
		this.properties = properties;
	}

	public List<HashMap<String, Object>> response() {
		List<HashMap<String, Object>> response = properties.stream().map(property -> property.data()).collect(Collectors.toList());
		return response;
	}
}
