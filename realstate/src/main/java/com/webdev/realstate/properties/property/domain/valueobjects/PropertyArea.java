package com.webdev.realstate.properties.property.domain.valueobjects;

import com.webdev.realstate.shared.domain.aggregate.DoubleValueObject;

public class PropertyArea extends DoubleValueObject {
	public PropertyArea(Double value) {
		this.value = value;
	}
}
