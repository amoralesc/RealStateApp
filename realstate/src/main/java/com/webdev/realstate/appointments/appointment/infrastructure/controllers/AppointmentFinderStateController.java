package com.webdev.realstate.appointments.appointment.infrastructure.controllers;

import com.webdev.realstate.appointments.appointment.application.find.AppointmentFindByState;
import com.webdev.realstate.appointments.appointment.application.find.AppointmentFindByStateResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@Tag(name = "Appointment", description = "Appointment REST API")
@RequestMapping(value = "/appointment")
public class AppointmentFinderStateController {

	@Autowired
	private AppointmentFindByState findByState;

	@Operation(summary = "Find appointments by state", description = "Find all appointments by the state (DONE in the system", tags = {"Appointment", "State"})
	@GetMapping(value = "/state")
	public ResponseEntity<List<HashMap<String, Object>>> execute(@RequestParam(name = "state") String appointmentState) {
		AppointmentFindByStateResponse response = new AppointmentFindByStateResponse(findByState.execute(appointmentState));
		return ResponseEntity.status(HttpStatus.OK).body(response.response());
	}

}