package com.webdev.realstate.appointments.appointment.application.find;

import com.webdev.realstate.appointments.appointment.domain.Appointment;
import com.webdev.realstate.appointments.appointment.domain.ports.AppointmentRepository;
import com.webdev.realstate.users.user.domain.valueobjects.UserId;
import com.webdev.realstate.users.user.domain.valueobjects.UserIsAgent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AppointmentFindByUserId {
    private AppointmentRepository repository;

    public AppointmentFindByUserId(AppointmentRepository repository) {
        this.repository = repository;
    }

    public List<Appointment>  execute(String userId, Boolean isAgent) {
        List<Appointment> appointments = new ArrayList<>();
        Optional<List<Appointment>> optionalAppointments = repository.findByUserId(new UserId(userId), new UserIsAgent(isAgent));
        if (optionalAppointments.isPresent()) {
            appointments = optionalAppointments.get();
        }
        return appointments;
    }
}
