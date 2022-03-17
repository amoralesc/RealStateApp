package com.webdev.realstate.properties.property.domain.valueobjects;

import com.webdev.realstate.shared.domain.aggregate.DoubleValueObject;

public class PropertyPrice extends DoubleValueObject {
	public PropertyPrice(Double value) {
		this.value = value;
	}
}
