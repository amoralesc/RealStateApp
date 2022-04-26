package com.webdev.realstate.appointments.appointment.infrastructure.controllers;

import com.webdev.realstate.appointments.appointment.application.update.AppointmentUpdate;
import com.webdev.realstate.appointments.appointment.domain.exceptions.InvalidAppointmentState;
import com.webdev.realstate.shared.infrastructure.schema.ErrorSchema;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@Tag(name = "Appointment", description = "Appointment REST API")
@RequestMapping(value = "/appointment")
public class AppointmentUpdateController {

	@Autowired
	private AppointmentUpdate update;

	@Operation(summary = "Update appointment", description = "Update an appointment", tags = {"Appointment"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Request updated"),
			@ApiResponse(responseCode = "400", description = "Invalid input", content = @Content(schema = @Schema(implementation = ErrorSchema.class)))
	})
	@PostMapping(value = "/update")
	public ResponseEntity execute(
			@RequestBody AppointmentUpdateRequest request) {
		update.execute(
				request.getId(),
				request.getState()
		);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(null);
	}

	@ExceptionHandler(value = {InvalidAppointmentState.class})
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ResponseEntity handleBadRequest(RuntimeException exception) {
		HashMap<String, String> response = new HashMap<>() {{
			put("error", exception.getMessage());
		}};
		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(response);
	}

	static class AppointmentUpdateRequest {
		@Schema(description = "Appointment id", example = "0f1c4b36-e610-4446-a3a3-a6083902b587")
		private String id;

		@Schema(description = "Appointment state, PENDING, DONE, CANCELLED", example = "DONE")
		private String state;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}
	}
}
