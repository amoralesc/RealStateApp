package com.webdev.realstate.properties.property.application.create;

import com.webdev.realstate.properties.property.domain.Property;
import com.webdev.realstate.properties.property.domain.entities.PropertyAddress;
import com.webdev.realstate.properties.property.domain.ports.PropertyRepository;
import com.webdev.realstate.properties.property.domain.valueobjects.*;

import java.util.HashMap;

public class PropertyCreator {

	private final PropertyRepository repository;

	public PropertyCreator(PropertyRepository repository) {
		this.repository = repository;
	}

	public void execute(
			String propertyId, String propertyDescription, String propertyType,
			Boolean propertyOfferType, Integer propertyQuantityRooms, Integer propertyQuantityBathrooms,
			Double propertyArea, Double propertyPrice, HashMap<String, Object> propertyAddress
	) {

		Property property = new Property();
		if(propertyAddress != null) {
			property = Property.create(
					new PropertyId(propertyId),
					new PropertyDescription(propertyDescription),
					new PropertyType(propertyType),
					new PropertyOfferType(propertyOfferType),
					new PropertyQuantityRooms(propertyQuantityRooms),
					new PropertyQuantityBathrooms(propertyQuantityBathrooms),
					new PropertyArea(propertyArea),
					new PropertyPrice(propertyPrice),
					new PropertyAddress(
							propertyAddress.get("id").toString(),
							propertyAddress.get("city").toString(),
							propertyAddress.get("detail").toString(),
							propertyAddress.get("info").toString(),
							propertyAddress.get("neighborhood").toString()
					)
			);
		} else {
			property = Property.create(
					new PropertyId(propertyId),
					new PropertyDescription(propertyDescription),
					new PropertyType(propertyType),
					new PropertyOfferType(propertyOfferType),
					new PropertyQuantityRooms(propertyQuantityRooms),
					new PropertyQuantityBathrooms(propertyQuantityBathrooms),
					new PropertyArea(propertyArea),
					new PropertyPrice(propertyPrice),
					null
			);
		}

		repository.save(property);
	}
}
