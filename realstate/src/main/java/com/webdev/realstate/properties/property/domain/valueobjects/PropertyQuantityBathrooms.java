package com.webdev.realstate.properties.property.domain.valueobjects;

import com.webdev.realstate.shared.domain.aggregate.IntegerValueObject;

public class PropertyQuantityBathrooms extends IntegerValueObject {

	public PropertyQuantityBathrooms() {
	}

	public PropertyQuantityBathrooms(Integer value) {
		this.value = value;
	}
}
