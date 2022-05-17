package com.webdev.realstate.properties.property.domain.valueobjects;

import com.webdev.realstate.shared.domain.aggregate.IntegerValueObject;

public class PropertyQuantityRooms extends IntegerValueObject {

	public PropertyQuantityRooms() {
	}

	public PropertyQuantityRooms(Integer value) {
		this.value = value;
	}
}
