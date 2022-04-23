package com.webdev.realstate.appointments.appointment.domain.ports;

import com.webdev.realstate.appointments.appointment.domain.Appointment;
import com.webdev.realstate.appointments.appointment.domain.valueobjects.AppointmentDate;
import com.webdev.realstate.appointments.appointment.domain.valueobjects.AppointmentState;
import com.webdev.realstate.users.user.domain.valueobjects.UserId;
import com.webdev.realstate.users.user.domain.valueobjects.UserIsAgent;

import java.util.List;
import java.util.Optional;

public interface AppointmentRepository {
	void save(Appointment appointment);

	void update(Appointment appointment);

	Optional<List<Appointment>> findByUserId(UserId userId, UserIsAgent isAgent);

	Optional<List<Appointment>> findByDate(AppointmentDate appointmentDate);

	Optional<List<Appointment>> findByState(AppointmentState appointmentState);
}
