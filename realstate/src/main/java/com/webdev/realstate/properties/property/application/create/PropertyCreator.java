package com.webdev.realstate.properties.property.application.create;

import com.webdev.realstate.properties.property.domain.Property;
import com.webdev.realstate.properties.property.domain.ports.PropertyRepository;
import com.webdev.realstate.properties.property.domain.valueobjects.*;

public class PropertyCreator {

	private final PropertyRepository repository;

	public PropertyCreator(PropertyRepository repository) {
		this.repository = repository;
	}

	public void execute(
			String propertyId, String propertyDescription, String propertyType,
			Boolean propertyOfferType, Integer propertyQuantityRooms, Integer propertyQuantityBathrooms,
			Double propertyArea, Double propertyPrice
	) {

		Property property = Property.create(
				new PropertyId(propertyId),
				new PropertyDescription(propertyDescription),
				new PropertyType(propertyType),
				new PropertyOfferType(propertyOfferType),
				new PropertyQuantityRooms(propertyQuantityRooms),
				new PropertyQuantityBathrooms(propertyQuantityBathrooms),
				new PropertyArea(propertyArea),
				new PropertyPrice(propertyPrice)
		);

		repository.save(property);
	}
}
