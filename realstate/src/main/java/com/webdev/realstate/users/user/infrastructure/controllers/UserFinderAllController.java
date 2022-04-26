package com.webdev.realstate.users.user.infrastructure.controllers;

import com.webdev.realstate.users.user.application.find_all.UserFindAll;
import com.webdev.realstate.users.user.application.find_all.UserFindAllResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@Tag(name = "User", description = "User REST API")
@RequestMapping(value = "/user")
public class UserFinderAllController {

	@Autowired
	private UserFindAll findAll;

	@Operation(summary = "Find all users", description = "Find all users in the system", tags = {"User"})
	@GetMapping(value = "/all")
	public ResponseEntity<List<HashMap<String, Object>>> execute() {
		UserFindAllResponse response =
				new UserFindAllResponse(
						findAll.execute()
				);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(response.response());
	}
}
