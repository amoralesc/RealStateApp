package com.webdev.realstate.appointments.appointment.infrastructure.controllers;

import com.webdev.realstate.appointments.appointment.application.find.AppointmentFindById;
import com.webdev.realstate.appointments.appointment.application.find.AppointmentFindByIdResponse;
import com.webdev.realstate.appointments.appointment.application.find.AppointmentFindByUser;
import com.webdev.realstate.appointments.appointment.application.find.AppointmentFindByUserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "Appointment", description = "Appointment REST API")
@RequestMapping(value = "/appointment")
public class AppointmentFinderController {

	@Autowired
	private AppointmentFindById findById;
	@Autowired
	private AppointmentFindByUser findByUser;

	@Operation(summary = "Find appointment by id", description = "Find an appointment given its UUID", tags = {"Appointment"})
	@GetMapping(value = "/find/{id}")
	public ResponseEntity<HashMap<String, Object>> execute(
			@PathVariable String id
	) {
		AppointmentFindByIdResponse response =
				new AppointmentFindByIdResponse(
						findById.execute(id)
				);
		return ResponseEntity.
				status(HttpStatus.OK)
				.body(response.response());
	}

	@Operation(summary = "Find appointments by user", description = "Find appointments given its user id and user type", tags = {"Appointment", "User"})
	@GetMapping(value = "/find")
	public ResponseEntity<List<HashMap<String, Object>>> execute(
			@RequestParam(name = "userId") String userId,
			@RequestParam(name = "isAgent") boolean isAgent,
			@RequestParam(name = "state", required = false) String state
	) {
		AppointmentFindByUserResponse response =
				new AppointmentFindByUserResponse(
						findByUser.execute(userId, isAgent, Optional.ofNullable(state))
				);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(response.response());
	}
}
