package com.webdev.realstate.appointments.appointment.application.find;

import com.webdev.realstate.appointments.appointment.domain.Appointment;
import com.webdev.realstate.appointments.appointment.domain.ports.AppointmentRepository;
import com.webdev.realstate.appointments.appointment.domain.valueobjects.AppointmentId;

import java.util.Optional;

public class AppointmentFindById {

	private final AppointmentRepository repository;

	public AppointmentFindById(AppointmentRepository repository) {
		this.repository = repository;
	}

	public Appointment execute(String id) {
		Appointment appointment = null;
		Optional<Appointment> optionalAppointment = repository.findById(new AppointmentId(id));
		if (optionalAppointment.isPresent()) {
			appointment = optionalAppointment.get();
		}
		return appointment;
	}
}
