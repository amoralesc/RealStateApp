package com.webdev.realstate.appointments.appointment.infrastructure.controllers;

import com.webdev.realstate.appointments.appointment.application.create.AppointmentCreator;
import com.webdev.realstate.appointments.appointment.domain.exceptions.AppointmentAlreadyExists;
import com.webdev.realstate.appointments.appointment.domain.exceptions.InvalidDate;
import com.webdev.realstate.shared.domain.exceptions.InvalidCustomUUID;
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

import java.util.Date;
import java.util.HashMap;

@RestController
@Tag(name = "Appointment", description = "Appointment REST API")
@RequestMapping(value = "/appointment")
public class AppointmentCreatorController {

	@Autowired
	private AppointmentCreator creator;

	@Operation(summary = "Create a new Appointment", description = "Create a new Appointment in the system", tags = {"Appointment"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Appointment created"),
			@ApiResponse(responseCode = "400", description = "Invalid input", content = @Content(schema = @Schema(implementation = ErrorSchema.class)))
	})
	@PostMapping(value = "/create")
	public ResponseEntity execute(@RequestBody AppointmentCreatorRequest request) {
		creator.execute(
				request.getId(),
				request.getDate(),
				request.getUserId(),
				request.getAgentId()
		);
		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}

	@ExceptionHandler(value = {InvalidCustomUUID.class, InvalidDate.class})
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ResponseEntity<HashMap> handleBadRequest(RuntimeException exception) {
		HashMap<String, String> response = new HashMap<>() {{
			put("error", exception.getMessage());
		}};
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	@ExceptionHandler(AppointmentAlreadyExists.class)
	@ResponseStatus(code = HttpStatus.CONFLICT)
	public ResponseEntity<HashMap> handleDuplicatedAppointment(RuntimeException exception) {
		HashMap<String, String> response = new HashMap<>() {{
			put("error", exception.getMessage());
		}};
		return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
	}

	static class AppointmentCreatorRequest {

		@Schema(description = "Appointment id", example = "564af8a6-a7ea-4733-acff-d2e5aada4e5a")
		private String id;

		@Schema(description = "Appointment date", example = "2022-04-15")
		private Date date;

		@Schema(description = "Appointment agent id", example = "564af8a6-a7ea-4733-acff-d2e5aada4e5a")
		private String agentId;

		@Schema(description = "Appointment user id", example = "564af8a6-a7ea-4733-acff-d2e5aada4e5a")
		private String userId;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public String getAgentId() {
			return agentId;
		}

		public void setAgentId(String agentId) {
			this.agentId = agentId;
		}

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}
	}
}
