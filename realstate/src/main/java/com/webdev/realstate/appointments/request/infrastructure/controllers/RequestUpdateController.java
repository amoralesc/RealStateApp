package com.webdev.realstate.appointments.request.infrastructure.controllers;

import com.webdev.realstate.appointments.request.application.update.RequestUpdate;
import com.webdev.realstate.appointments.request.domain.exceptions.InvalidRequestState;
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
@Tag(name = "Request", description = "Request REST API")
@RequestMapping(value = "/request")
public class RequestUpdateController {

	@Autowired
	private RequestUpdate update;

	@Operation(summary = "Update request", description = "Update a request", tags = {"Request"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Request updated"),
			@ApiResponse(responseCode = "400", description = "Invalid input", content = @Content(schema = @Schema(implementation = ErrorSchema.class)))
	})
	@PostMapping(value = "/update")
	public ResponseEntity execute(
			@RequestBody RequestUpdateRequest request) {
		update.execute(
				request.getId(),
				request.getState()
		);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(null);
	}

	@ExceptionHandler(value = {InvalidRequestState.class})
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ResponseEntity handleBadRequest(RuntimeException exception) {
		HashMap<String, String> response = new HashMap<>() {{
			put("error", exception.getMessage());
		}};
		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(response);
	}

	static class RequestUpdateRequest {
		@Schema(description = "Request id", example = "0f1c4b36-e610-4446-a3a3-a6083902b587")
		private String id;

		@Schema(description = "Request state, PENDING, ACCEPTED, REJECTED", example = "ACCEPTED")
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
