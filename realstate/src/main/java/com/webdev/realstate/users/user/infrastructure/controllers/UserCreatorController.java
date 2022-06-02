package com.webdev.realstate.users.user.infrastructure.controllers;

import com.webdev.realstate.shared.infrastructure.schema.ErrorSchema;
import com.webdev.realstate.users.user.application.create.UserCreator;
import com.webdev.realstate.users.user.domain.exceptions.InvalidLength;
import com.webdev.realstate.users.user.domain.exceptions.InvalidPassword;
import com.webdev.realstate.users.user.domain.exceptions.InvalidUserEmail;
import com.webdev.realstate.users.user.domain.exceptions.UserAlreadyExists;
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
@Tag(name = "User", description = "User REST API")
@RequestMapping(value = "/user")
public class UserCreatorController {

	@Autowired
	private UserCreator creator;

	@Operation(summary = "Create a new User", description = "Create a new User in the system", tags = {"User"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "User created"),
			@ApiResponse(responseCode = "400", description = "Invalid input", content = @Content(schema = @Schema(implementation = ErrorSchema.class))),
			@ApiResponse(responseCode = "409", description = "User already exists", content = @Content(schema = @Schema(implementation = ErrorSchema.class)))
	})
	@CrossOrigin(origins = "*", methods= {RequestMethod.GET})
	@PostMapping(value = "/create")
	public ResponseEntity execute(@RequestBody UserCreatorRequest request) {

		creator.execute(
				request.getId(),
				request.getName(),
				request.getEmail(),
				request.getPassword(),
				request.getIsAgent()
		);

		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(null);
	}

	@ExceptionHandler(value = {InvalidUserEmail.class, InvalidLength.class, InvalidPassword.class})
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ResponseEntity<HashMap> handleBadRequest(RuntimeException exception) {
		HashMap<String, String> response = new HashMap<>() {{
			put("error", exception.getMessage());
		}};
		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(response);
	}

	@ExceptionHandler(UserAlreadyExists.class)
	@ResponseStatus(code = HttpStatus.CONFLICT)
	public ResponseEntity<HashMap> handleDuplicatedUser(RuntimeException exception) {
		HashMap<String, String> response = new HashMap<>() {{
			put("error", exception.getMessage());
		}};
		return ResponseEntity
				.status(HttpStatus.CONFLICT)
				.body(response);
	}

	static class UserCreatorRequest {
		@Schema(description = "User id", example = "0f1c4b36-e610-4446-a3a3-a6083902b587")
		private String id;

		@Schema(description = "User name, between 5 and 30 characters", example = "John Doe")
		private String name;

		@Schema(description = "User email, contains @", example = "john.doe@gmail.com")
		private String email;

		@Schema(description = "User password, at least 8 characters", example = "Password123")
		private String password;

		@Schema(description = "User type, true if it's an agent, false if it's not", example = "1")
		private boolean isAgent;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public boolean getIsAgent() {
			return isAgent;
		}

		public void setAgent(boolean agent) {
			isAgent = agent;
		}
	}

}
