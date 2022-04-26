package com.webdev.realstate.properties.property.domain;

import com.webdev.realstate.properties.property.domain.entities.PropertyAddress;
import com.webdev.realstate.properties.property.domain.valueobjects.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Property {
	PropertyId propertyId;
	PropertyDescription propertyDescription;
	PropertyType propertyType;
	PropertyOfferType propertyOfferType;
	PropertyQuantityRooms propertyQuantityRooms;
	PropertyQuantityBathrooms propertyQuantityBathrooms;
	PropertyArea propertyArea;
	PropertyPrice propertyPrice;
	Optional<List<PropertyAddress>> propertyAddress;

	public Property(
			PropertyId propertyId, PropertyDescription propertyDescription, PropertyType propertyType,
			PropertyOfferType propertyOfferType, PropertyQuantityRooms propertyQuantityRooms,
			PropertyQuantityBathrooms propertyQuantityBathrooms, PropertyArea propertyArea,
			PropertyPrice propertyPrice, Optional<List<PropertyAddress>> propertyAddress
	) {
		this.propertyId = propertyId;
		this.propertyDescription = propertyDescription;
		this.propertyType = propertyType;
		this.propertyOfferType = propertyOfferType;
		this.propertyQuantityRooms = propertyQuantityRooms;
		this.propertyQuantityBathrooms = propertyQuantityBathrooms;
		this.propertyArea = propertyArea;
		this.propertyPrice = propertyPrice;
		this.propertyAddress = propertyAddress;
	}

	public static Property create(
			PropertyId propertyId, PropertyDescription propertyDescription, PropertyType propertyType,
			PropertyQuantityRooms propertyQuantityRooms, PropertyQuantityBathrooms propertyQuantityBathrooms,
			PropertyArea propertyArea, PropertyPrice propertyPrice
	) {
		Property property = new Property(
				propertyId,
				propertyDescription,
				propertyType,
				new PropertyOfferType(false),
				propertyQuantityRooms,
				propertyQuantityBathrooms,
				propertyArea,
				propertyPrice,
				Optional.empty()
		);
		return property;
	}

	public HashMap<String, Object> data() {
		HashMap<String, Object> data = new HashMap<>() {{
			put("id", propertyId.value());
			put("description", propertyDescription.value());
			put("propertyType", propertyType.value());
			put("offerType", propertyOfferType.value());
			put("quantityRooms", propertyQuantityRooms.value());
			put("quantityBathrooms", propertyQuantityBathrooms.value());
			put("area", propertyArea.value());
			put("price", propertyPrice.value());
			put("address", createAddress());
		}};
		return data;
	}

	private List<HashMap<String, Object>> createAddress() {
		List<HashMap<String, Object>> list = new ArrayList<>();
		if (!propertyAddress.isEmpty()) {
			list = propertyAddress.get().stream().map(
					address -> address.data()
			).collect(Collectors.toList());
		}
		return list;
	}
}
