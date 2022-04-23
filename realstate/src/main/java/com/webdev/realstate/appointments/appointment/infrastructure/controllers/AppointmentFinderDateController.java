package com.webdev.realstate.appointments.appointment.infrastructure.controllers;

import com.webdev.realstate.appointments.appointment.application.find.AppointmentFindByDate;
import com.webdev.realstate.appointments.appointment.application.find.AppointmentFindByDateResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@Tag(name = "Appointment", description = "Appointment REST API")
@RequestMapping(value = "/appointment")
public class AppointmentFinderDateController {

	@Autowired
	private AppointmentFindByDate findByDate;

	@Operation(summary = "Find appointments by date", description = "Find all appointments by the date (2022-04-15 in the system", tags = {"Appointment", "Date"})
	@GetMapping(value = "/date")
	public ResponseEntity<List<HashMap<String, Object>>> execute(@RequestParam(name = "date") Date appointmentDate) {
		AppointmentFindByDateResponse response = new AppointmentFindByDateResponse(findByDate.execute(appointmentDate));
		return ResponseEntity.status(HttpStatus.OK).body(response.response());
	}

}
