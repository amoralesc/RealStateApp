package com.webdev.realstate.appointments.request.infrastructure.controllers;

import com.webdev.realstate.appointments.request.application.delete.RequestDelete;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Request", description = "Request REST API")
@RequestMapping(value = "/request")
public class RequestDeleteController {

	@Autowired
	private RequestDelete delete;

	@Operation(summary = "Delete request", description = "Delete a request in the system", tags = {"Request"})
	@DeleteMapping(value = "/delete")
	public ResponseEntity execute(
			RequestDeleteRequest request
	) {
		delete.execute(
				request.getId()
		);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(null);
	}

	static class RequestDeleteRequest {
		@Schema(description = "Request id", example = "0f1c4b36-e610-4446-a3a3-a6083902b587")
		private String id;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}
	}
}
