package com.webdev.realstate.properties.property.application.update;

import com.webdev.realstate.appointments.appointment.domain.Appointment;
import com.webdev.realstate.appointments.appointment.domain.ports.AppointmentRepository;
import com.webdev.realstate.appointments.appointment.domain.valueobjects.AppointmentId;
import com.webdev.realstate.appointments.appointment.domain.valueobjects.AppointmentState;
import com.webdev.realstate.properties.property.domain.Property;
import com.webdev.realstate.properties.property.domain.ports.PropertyRepository;
import com.webdev.realstate.properties.property.domain.valueobjects.*;
import com.webdev.realstate.shared.domain.bus.event.EventBus;
import com.webdev.realstate.users.user.domain.User;
import com.webdev.realstate.users.user.domain.entities.UserPhone;
import com.webdev.realstate.users.user.domain.ports.UserRepository;
import com.webdev.realstate.users.user.domain.valueobjects.UserId;
import com.webdev.realstate.users.user.domain.valueobjects.UserName;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PropertyUpdate {

	private final PropertyRepository repository;

	public PropertyUpdate(PropertyRepository repository) {
		this.repository = repository;
	}

	public void execute(String id, String description, String propertyType, boolean offerType, int quantityRooms, int quantityBathrooms, double area, double price) {
		Optional<Property> optionalProperty = repository.findById(new PropertyId(id));
		if (optionalProperty.isPresent()) {
			Property property = optionalProperty.get();

			if (description != null && !description.isEmpty() && propertyType != null && !propertyType.isEmpty()) {
				property.update(
							new PropertyDescription(description),
							new PropertyType(propertyType),
							new PropertyOfferType(offerType),
							new PropertyQuantityRooms(quantityRooms),
							new PropertyQuantityBathrooms(quantityBathrooms),
							new PropertyArea(area),
							new PropertyPrice(price)
						);
			}

			repository.update(property);
		}
	}
}
