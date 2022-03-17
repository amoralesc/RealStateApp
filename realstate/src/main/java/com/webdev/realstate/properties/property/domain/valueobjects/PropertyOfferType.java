package com.webdev.realstate.properties.property.domain.valueobjects;

import com.webdev.realstate.shared.domain.aggregate.BooleanValueObject;

public class PropertyOfferType extends BooleanValueObject {
	public PropertyOfferType(Boolean value) {
		this.value = value;
	}
}
