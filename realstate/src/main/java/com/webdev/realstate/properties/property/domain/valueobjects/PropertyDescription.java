package com.webdev.realstate.properties.property.domain.valueobjects;

import com.webdev.realstate.shared.domain.aggregate.StringValueObject;

public class PropertyDescription extends StringValueObject {
	public PropertyDescription(String value) {
		this.value = value;
	}
}
