package com.webdev.realstate.properties.property.application.find;

import com.webdev.realstate.properties.property.domain.Property;
import com.webdev.realstate.properties.property.domain.ports.PropertyRepository;
import com.webdev.realstate.properties.property.domain.valueobjects.PropertyOfferType;
import com.webdev.realstate.properties.property.domain.valueobjects.PropertyQuantityRooms;
import com.webdev.realstate.properties.property.domain.valueobjects.PropertyType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PropertyFindByFilter {

	private PropertyRepository repository;

	public PropertyFindByFilter(PropertyRepository repository) {
		this.repository = repository;
	}

	public List<Property> execute(
			Optional<String> propertyType,
			Optional<Boolean> offerType,
			Optional<Integer> quantityRooms,
			Optional<Integer> quantityBathrooms
	) {
		List<Property> properties = new ArrayList<>();
		Optional<List<Property>> optionalProperties
				= repository.findAll();

		if (optionalProperties.isPresent()) {
			properties = optionalProperties.get();

			if (propertyType.isPresent()) {
				properties = properties.stream().filter(
						property -> ((String) property.data().get("propertyType"))
								.equals(new PropertyType(propertyType.get()).value())
				).collect(Collectors.toList());
			}

			if (offerType.isPresent()) {
				properties = properties.stream().filter(
						property -> ((Boolean) property.data().get("offerType"))
								.equals(new PropertyOfferType(offerType.get()).value())
				).collect(Collectors.toList());
			}

			if (quantityRooms.isPresent()) {
				properties = properties.stream().filter(
						property -> ((Integer) property.data().get("quantityRooms"))
								.equals(new PropertyQuantityRooms(quantityRooms.get()).value())
				).collect(Collectors.toList());
			}

			if (quantityBathrooms.isPresent()) {
				properties = properties.stream().filter(
						property -> ((Integer) property.data().get("quantityBathrooms"))
								.equals(new PropertyQuantityRooms(quantityBathrooms.get()).value())
				).collect(Collectors.toList());
			}
		}
		return properties;
	}
}
