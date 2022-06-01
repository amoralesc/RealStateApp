package com.webdev.realstate.appointments.appointment.application.create;

import com.webdev.realstate.appointments.appointment.domain.Appointment;
import com.webdev.realstate.appointments.appointment.domain.ports.AppointmentRepository;
import com.webdev.realstate.appointments.appointment.domain.valueobjects.AppointmentDate;
import com.webdev.realstate.appointments.appointment.domain.valueobjects.AppointmentId;
import com.webdev.realstate.properties.property.domain.valueobjects.PropertyId;
import com.webdev.realstate.shared.domain.bus.event.EventBus;
import com.webdev.realstate.users.user.domain.valueobjects.UserId;

import java.util.Date;

public class AppointmentCreator {

	private final AppointmentRepository repository;
	private final EventBus eventBus;

	public AppointmentCreator(AppointmentRepository repository, EventBus eventBus) {
		this.eventBus = eventBus;
		this.repository = repository;
	}

	public void execute(
			String appointmentId, Date appointmentDate,
			String propertyId, String userId, String agentId) {
		Appointment appointment = Appointment.create(
				new AppointmentId(appointmentId),
				new AppointmentDate(appointmentDate),
				new PropertyId(propertyId),
				new UserId(userId),
				new UserId(agentId)
		);
		repository.save(appointment);
		this.eventBus.publish(appointment.pullDomainEvents());
	}
}
