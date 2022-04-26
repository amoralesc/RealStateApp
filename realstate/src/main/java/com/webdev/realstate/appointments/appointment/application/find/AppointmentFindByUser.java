package com.webdev.realstate.appointments.appointment.application.find;

import com.webdev.realstate.appointments.appointment.domain.Appointment;
import com.webdev.realstate.appointments.appointment.domain.ports.AppointmentRepository;
import com.webdev.realstate.appointments.appointment.domain.valueobjects.AppointmentState;
import com.webdev.realstate.users.user.domain.valueobjects.UserId;
import com.webdev.realstate.users.user.domain.valueobjects.UserIsAgent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AppointmentFindByUser {
	private AppointmentRepository repository;

	public AppointmentFindByUser(AppointmentRepository repository) {
		this.repository = repository;
	}

	public List<Appointment> execute(String userId, Boolean isAgent, Optional<String> state) {
		List<Appointment> appointments = new ArrayList<>();
		Optional<List<Appointment>> optionalAppointments =
				repository.findByUser(
						new UserId(userId),
						new UserIsAgent(isAgent)
				);

		if (optionalAppointments.isPresent()) {
			appointments = optionalAppointments.get();
		}
		if (state.isPresent()) {
			AppointmentState appointmentState = new AppointmentState(state.get());

			appointments = appointments.stream().filter(appointment ->
					appointment.data().get("state").equals(appointmentState.value())
			).collect(Collectors.toList());
		}
		return appointments;
	}
}
