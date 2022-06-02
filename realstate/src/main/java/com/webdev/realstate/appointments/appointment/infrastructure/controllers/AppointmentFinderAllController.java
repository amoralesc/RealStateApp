package com.webdev.realstate.appointments.appointment.infrastructure.controllers;

import com.webdev.realstate.appointments.appointment.application.find_all.AppointmentFindAll;
import com.webdev.realstate.appointments.appointment.application.find_all.AppointmentFindAllResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@Tag(name = "Appointment", description = "Appointment REST API")
@RequestMapping(value = "/appointment")
public class AppointmentFinderAllController {

	@Autowired
	private AppointmentFindAll findAll;

	@Operation(summary = "Find all appointments", description = "Find all appointments in the system", tags = {"Appointment"})
	@CrossOrigin(origins = "*", methods= {RequestMethod.GET})
	@GetMapping(value = "/all")
	public ResponseEntity<List<HashMap<String, Object>>> execute() {
		AppointmentFindAllResponse response =
				new AppointmentFindAllResponse(
						findAll.execute()
				);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(response.response());
	}
}
