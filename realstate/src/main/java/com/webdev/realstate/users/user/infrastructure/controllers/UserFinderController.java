package com.webdev.realstate.users.user.infrastructure.controllers;

import com.webdev.realstate.users.user.application.find.UserFindById;
import com.webdev.realstate.users.user.application.find.UserFindByIdResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@Tag(name = "User", description = "User REST API")
@RequestMapping(value = "/user")
public class UserFinderController {

	@Autowired
	private UserFindById findById;

	@Operation(summary = "Find user by id", description = "Find user given its UUID", tags = {"User"})
	@GetMapping(value = "/{id}")
	public ResponseEntity<HashMap<String, Object>> execute(@PathVariable String id) {
		UserFindByIdResponse response =
				new UserFindByIdResponse(
						findById.execute(id)
				);
		return ResponseEntity.
				status(HttpStatus.OK)
				.body(response.response());
	}
}
