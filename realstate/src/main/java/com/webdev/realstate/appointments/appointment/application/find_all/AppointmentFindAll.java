package com.webdev.realstate.appointments.appointment.application.find_all;

import com.webdev.realstate.appointments.appointment.domain.Appointment;
import com.webdev.realstate.appointments.appointment.domain.ports.AppointmentRepository;

import java.util.ArrayList;
import java.util.List;

public class AppointmentFindAll {

	private AppointmentRepository repository;

	public AppointmentFindAll(AppointmentRepository repository) {
		this.repository = repository;
	}

	public List<Appointment> execute() {
		List<Appointment> appointments = new ArrayList<>();
		repository.findAll().ifPresent(
				appointments::addAll
		);
		return appointments;
	}
}
