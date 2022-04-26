package com.webdev.realstate.shared.infrastructure.rabbitmq;

import com.webdev.realstate.appointments.appointment.domain.events.AppointmentCreatedDomainEvent;
import com.webdev.realstate.appointments.appointment.domain.events.AppointmentUpdatedDomainEvent;
import com.webdev.realstate.shared.domain.bus.event.DomainEvent;

import java.util.HashMap;

public class DomainEventsInformation {

	private final HashMap<String, Class<? extends DomainEvent>> indexedDomainEvent = new HashMap<>();
	private final HashMap<String, String> domainEventSubscribers = new HashMap<>();

	public DomainEventsInformation() {
		indexedDomainEvent.put(
				"create.appointment",
				AppointmentCreatedDomainEvent.class
		);
		indexedDomainEvent.put(
				"update.appointment",
				AppointmentUpdatedDomainEvent.class
		);
		indexedDomainEvent.put(
				"create.request",
				AppointmentCreatedDomainEvent.class
		);
		indexedDomainEvent.put(
				"update.request",
				AppointmentUpdatedDomainEvent.class
		);


		domainEventSubscribers.put(
				"realstate.appointments.appointment.create.appointment",
				"AddAppointmentOnAppointmentCreated"
		);
		domainEventSubscribers.put(
				"realstate.appointments.appointment.update.appointment",
				"UpdateAppointmentOnAppointmentUpdated"
		);
		domainEventSubscribers.put(
				"realstate.appointments.request.create.request",
				"AddRequestOnRequestCreated"
		);
		domainEventSubscribers.put(
				"realstate.appointments.request.update.request",
				"UpdateRequestOnRequestUpdated"
		);

	}

	public Class<? extends DomainEvent> getDomainEvent(String name) {
		return indexedDomainEvent.get(name);
	}

	public boolean validateEventSubscriber(String name) {
		return domainEventSubscribers.containsKey(name);
	}

	public String getEventSubscriber(String name) {
		return domainEventSubscribers.get(name);
	}

}
