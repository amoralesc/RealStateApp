package com.webdev.realstate.appointments.appointment.application.find;

import com.webdev.realstate.appointments.appointment.domain.Appointment;
import com.webdev.realstate.appointments.appointment.domain.ports.AppointmentRepository;
import com.webdev.realstate.appointments.appointment.domain.valueobjects.AppointmentDate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class AppointmentFindByDate {
	private AppointmentRepository repository;

	public AppointmentFindByDate(AppointmentRepository repository) {
		this.repository = repository;
	}

	public List<Appointment> execute(Date appointmentDate) {
		List<Appointment> appointments = new ArrayList<>();
		Optional<List<Appointment>> optionalAppointments = repository.findByDate(new AppointmentDate(appointmentDate));
		if (optionalAppointments.isPresent()) {
			appointments = optionalAppointments.get();
		}
		return appointments;
	}
}
