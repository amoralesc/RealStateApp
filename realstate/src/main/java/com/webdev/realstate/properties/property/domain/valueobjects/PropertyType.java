package com.webdev.realstate.properties.property.domain.valueobjects;

import com.webdev.realstate.shared.domain.aggregate.BooleanValueObject;

public class PropertyType extends BooleanValueObject {
	public PropertyType(Boolean value) {
		this.value = value;
	}
}
