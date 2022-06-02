package com.webdev.realstate.users.user.infrastructure.controllers;

import com.webdev.realstate.shared.infrastructure.schema.ErrorSchema;
import com.webdev.realstate.users.user.application.update.UserUpdate;
import com.webdev.realstate.users.user.domain.exceptions.InvalidLength;
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
import java.util.List;

@RestController
@Tag(name = "User", description = "User REST API")
@RequestMapping(value = "/user")
public class UserUpdateController {

	@Autowired
	private UserUpdate update;

	@Operation(summary = "Update user", description = "Update an user details", tags = {"User"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "User updated"),
			@ApiResponse(responseCode = "400", description = "Invalid input", content = @Content(schema = @Schema(implementation = ErrorSchema.class)))
	})
	@CrossOrigin(origins = "*", methods= {RequestMethod.PUT})
	@PutMapping(value = "/update")
	public ResponseEntity execute(@RequestBody UserUpdateRequest request) {
		update.execute(
				request.getEmail(),
				request.getName(),
				request.getPhones()
		);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(null);
	}

	@ExceptionHandler(value = {InvalidLength.class})
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ResponseEntity handleBadRequest(RuntimeException exception) {
		HashMap<String, String> response = new HashMap<>() {{
			put("error", exception.getMessage());
		}};
		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(response);
	}

	static class UserUpdateRequest {
		@Schema(description = "User email", example = "a@gmail.com")
		private String email;

		@Schema(description = "User name, between 5 and 30 characters", example = "John Doe")
		private String name;

		@Schema(description = "User phones list", example = "[\"countryCode\":\"+1\",\"number\":\"1234567890\"]")
		private List<HashMap<String, Object>> phones;

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<HashMap<String, Object>> getPhones() {
			return phones;
		}

		public void setPhones(List<HashMap<String, Object>> phones) {
			this.phones = phones;
		}
	}
}
