package com.webdev.realstate.users.user.infrastructure.controllers;

import com.webdev.realstate.users.user.application.delete.UserDelete;
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
@Tag(name = "User", description = "User REST API")
@RequestMapping(value = "/user")
public class UserDeleteController {

	@Autowired
	private UserDelete delete;

	@Operation(summary = "Delete user", description = "Delete an user in the system", tags = {"User"})
	@DeleteMapping(value = "/delete")
	public ResponseEntity execute(@RequestBody UserDeleteRequest request) {
		delete.execute(
				request.getId()
		);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(null);
	}

	static class UserDeleteRequest {
		@Schema(description = "User id", example = "0f1c4b36-e610-4446-a3a3-a6083902b587")
		private String id;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}
	}
}
