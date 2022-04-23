package com.webdev.realstate.appointments.appointment.application.create;

import com.webdev.realstate.appointments.appointment.domain.Appointment;
import com.webdev.realstate.appointments.appointment.domain.ports.AppointmentRepository;
import com.webdev.realstate.appointments.appointment.domain.valueobjects.AppointmentDate;
import com.webdev.realstate.appointments.appointment.domain.valueobjects.AppointmentId;
import com.webdev.realstate.users.user.domain.valueobjects.UserId;

import java.util.Date;

public class AppointmentCreator {

	private AppointmentRepository repository;

	public AppointmentCreator(AppointmentRepository repository) {
		this.repository = repository;
	}

	public void execute(String appointmentId, Date appointmentDate, String userId, String agentId) {
		Appointment appointment = Appointment.create(
				new AppointmentId(appointmentId),
				new AppointmentDate(appointmentDate),
				new UserId(userId),
				new UserId(agentId)
		);
		repository.save(appointment);
	}
}
