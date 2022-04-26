package com.webdev.realstate.appointments.appointment.application.update;

import com.webdev.realstate.appointments.appointment.domain.Appointment;
import com.webdev.realstate.appointments.appointment.domain.ports.AppointmentRepository;
import com.webdev.realstate.appointments.appointment.domain.valueobjects.AppointmentId;
import com.webdev.realstate.appointments.appointment.domain.valueobjects.AppointmentState;

import java.util.Optional;

public class AppointmentUpdate {

	private AppointmentRepository repository;

	public AppointmentUpdate(AppointmentRepository repository) {
		this.repository = repository;
	}

	public void execute(String appointmentId, String appointmentState) {
		Optional<Appointment> optionalAppointment =
				repository.findById(new AppointmentId(appointmentId));

		if (optionalAppointment.isPresent()) {
			Appointment appointment = optionalAppointment.get();
			appointment.updateState(
					new AppointmentState(appointmentState)
			);

			repository.update(appointment);
		}
	}
}
