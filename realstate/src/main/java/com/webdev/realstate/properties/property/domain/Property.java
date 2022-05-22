package com.webdev.realstate.properties.property.domain;

import com.webdev.realstate.properties.property.domain.entities.PropertyAddress;
import com.webdev.realstate.properties.property.domain.valueobjects.*;

import java.util.HashMap;
import java.util.Optional;

public class Property {
	PropertyId propertyId;
	PropertyDescription propertyDescription;
	PropertyType propertyType;
	PropertyOfferType propertyOfferType;
	PropertyQuantityRooms propertyQuantityRooms;
	PropertyQuantityBathrooms propertyQuantityBathrooms;
	PropertyArea propertyArea;
	PropertyPrice propertyPrice;
	Optional<PropertyAddress> propertyAddress;

	public Property() {
	}

	public Property(
			PropertyId propertyId, PropertyDescription propertyDescription,
			PropertyType propertyType, PropertyOfferType propertyOfferType,
			PropertyQuantityRooms propertyQuantityRooms, PropertyQuantityBathrooms propertyQuantityBathrooms,
			PropertyArea propertyArea, PropertyPrice propertyPrice,
			Optional<PropertyAddress> propertyAddress
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
			PropertyOfferType propertyOfferType, PropertyQuantityRooms propertyQuantityRooms,
			PropertyQuantityBathrooms propertyQuantityBathrooms, PropertyArea propertyArea, PropertyPrice propertyPrice,
			PropertyAddress propertyAddress
	) {
		Property property = new Property(
				propertyId,
				propertyDescription,
				propertyType,
				propertyOfferType,
				propertyQuantityRooms,
				propertyQuantityBathrooms,
				propertyArea,
				propertyPrice,
				Optional.ofNullable(propertyAddress)
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
			//put("address", createAddress());
		}};
		return data;
	}

	private HashMap<String, Object> createAddress() {
		HashMap<String, Object> data = new HashMap<>();
		propertyAddress.ifPresent(address ->
				data.putAll(address.data())
		);
		return data;
	}

	public void updateAddress(PropertyAddress propertyAddress) {
		this.propertyAddress = Optional.of(propertyAddress);
	}
}
