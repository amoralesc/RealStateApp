package com.webdev.realstate.appointments.appointment.application.find;

import com.webdev.realstate.appointments.appointment.domain.Appointment;
import com.webdev.realstate.appointments.appointment.domain.ports.AppointmentRepository;
import com.webdev.realstate.appointments.appointment.domain.valueobjects.AppointmentState;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AppointmentFindByState {
	private AppointmentRepository repository;

	public AppointmentFindByState(AppointmentRepository repository) {
		this.repository = repository;
	}

	public List<Appointment> execute(String appointmentState) {
		List<Appointment> appointments = new ArrayList<>();
		Optional<List<Appointment>> optionalAppointments = repository.findByState(new AppointmentState(appointmentState));
		if (optionalAppointments.isPresent()) {
			appointments = optionalAppointments.get();
		}
		return appointments;
	}
}
