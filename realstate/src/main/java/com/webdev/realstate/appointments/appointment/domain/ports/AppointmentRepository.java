package com.webdev.realstate.appointments.appointment.domain.ports;

import com.webdev.realstate.appointments.appointment.domain.Appointment;
import com.webdev.realstate.appointments.appointment.domain.valueobjects.AppointmentId;
import com.webdev.realstate.users.user.domain.valueobjects.UserId;
import com.webdev.realstate.users.user.domain.valueobjects.UserIsAgent;

import java.util.List;
import java.util.Optional;

public interface AppointmentRepository {

	void save(Appointment appointment);

	void update(Appointment appointment);

	void delete(Appointment appointment);

	Optional<Appointment> findById(AppointmentId appointmentId);

	Optional<List<Appointment>> findByUser(UserId userId, UserIsAgent isAgent);

	Optional<List<Appointment>> findAll();
}
