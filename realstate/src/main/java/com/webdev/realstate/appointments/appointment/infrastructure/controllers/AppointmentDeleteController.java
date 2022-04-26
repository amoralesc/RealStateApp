package com.webdev.realstate.appointments.appointment.infrastructure.controllers;

import com.webdev.realstate.appointments.appointment.application.delete.AppointmentDelete;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Appointment", description = "Appointment REST API")
@RequestMapping(value = "/appointment")
public class AppointmentDeleteController {

	@Autowired
	private AppointmentDelete delete;

	@Operation(summary = "Delete appointment", description = "Delete an appointment in the system", tags = {"Appointment"})
	@DeleteMapping(value = "/delete")
	public ResponseEntity execute(
			@RequestBody AppointmentDeleteRequest request
	) {
		delete.execute(
				request.getId()
		);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(null);
	}

	static class AppointmentDeleteRequest {
		@Schema(description = "Appointment id", example = "0f1c4b36-e610-4446-a3a3-a6083902b587")
		private String id;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}
	}
}
