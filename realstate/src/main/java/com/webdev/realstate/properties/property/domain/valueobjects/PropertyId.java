package com.webdev.realstate.properties.property.domain.valueobjects;

import com.webdev.realstate.shared.domain.aggregate.CustomUUID;

public class PropertyId extends CustomUUID {

	public PropertyId() {
	}

	public PropertyId(String value) {
		super(value);
	}
}
