package com.webdev.realstate.appointments.appointment.application.delete;

import com.webdev.realstate.appointments.appointment.domain.Appointment;
import com.webdev.realstate.appointments.appointment.domain.ports.AppointmentRepository;
import com.webdev.realstate.appointments.appointment.domain.valueobjects.AppointmentId;

import java.util.Optional;

public class AppointmentDelete {

	private final AppointmentRepository repository;

	public AppointmentDelete(AppointmentRepository repository) {
		this.repository = repository;
	}

	public void execute(String id) {
		Optional<Appointment> optionalAppointment =
				repository.findById(new AppointmentId(id));
		optionalAppointment.ifPresent(
				appointment -> repository.delete(appointment)
		);
	}
}
